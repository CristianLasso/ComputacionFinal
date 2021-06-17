package com.taller1.CristianLasso.test.integrales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.Eventstatus;
import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.repository.AutotransitionRepository;
import com.taller1.CristianLasso.back.repository.EventstatusRepository;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;
import com.taller1.CristianLasso.back.service.AutotransitionServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AutotransitionServiceTest {

	private AutotransitionRepository autotranRepo;
	private FevInstitutionRepository instRepo;
	private EventstatusRepository eventRepo;
	private AutotransitionServiceImp autotranService;
	
	@Autowired
	public AutotransitionServiceTest(AutotransitionRepository autotranRepo, FevInstitutionRepository instRepo, EventstatusRepository eventRepo, AutotransitionServiceImp autotranService) {
		this.autotranRepo = autotranRepo;
		this.instRepo = instRepo;
		this.eventRepo = eventRepo;
		this.autotranService = autotranService;
	}
	
	public Autotransition setUp1() {
		Autotransition auto = new Autotransition();
		autotranRepo.save(auto);
		return auto;
	}
	
	public FevInstitution setUp2() {
		FevInstitution inst = new FevInstitution();
		instRepo.save(inst);
		return inst;
	}
	
	public Eventstatus setUp3() {
		Eventstatus event = new Eventstatus();
		eventRepo.save(event);
		return event;
	}
	
	public Eventstatus setUp4() {
		Eventstatus event = new Eventstatus();
		eventRepo.save(event);
		return event;
	}
	
	@Test
	public void saveAutotransitionTest() {
		
		Autotransition auto = setUp1();
		auto.setAutotranId(25);
		auto.setAutotranName("VojabesTest");
		auto.setInstInstId(setUp2().getInstId());
		auto.setEventstatus1(setUp3());
		auto.setEventstatus2(setUp4());
		auto.setAutotranIsactive("Y");
		auto.setAutotranLogicaloperand("AND");
		
		assertEquals(autotranService.saveAutotransition(25, "Y", "AND", "VojabesTest", setUp2().getInstId(), setUp3().getEvestatId(), setUp4().getEvestatId()).getAutotranId(), auto.getAutotranId());
		
	}
	
	@Test
	public void saveAutotransitionInvalidNameTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "Y", "AND", "", setUp2().getInstId(), setUp3().getEvestatId(), setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveAutotransitionInvalidLogicalOperandTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "Y", "o", "VojabesTest", setUp2().getInstId(), setUp3().getEvestatId(), setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveAutotransitionInvalidIsActiveTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "yes", "AND", "VojabesTest", setUp2().getInstId(), setUp3().getEvestatId(), setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveAutotransitionInstitutionNullTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "Y", "AND", "VojabesTest", 0, setUp3().getEvestatId(), setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveAutotransitionEventNullTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "Y", "AND", "VojabesTest", setUp2().getInstId(), 0, setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionInvalidNameTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "Y", "AND", "", setUp2().getInstId(), setUp3().getEvestatId(), setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionInvalidLogicalOperandTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "Y", "o", "VojabesTest", setUp2().getInstId(), setUp3().getEvestatId(), setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionInvalidIsActiveTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "yes", "AND", "VojabesTest", setUp2().getInstId(), setUp3().getEvestatId(), setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionInstitutionNullTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "Y", "AND", "VojabesTest", 0, setUp3().getEvestatId(), setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionEventNullTest() {
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "Y", "AND", "VojabesTest", setUp2().getInstId(), 0, setUp4().getEvestatId()), "Exception not thrown");
		
	}
	
}
