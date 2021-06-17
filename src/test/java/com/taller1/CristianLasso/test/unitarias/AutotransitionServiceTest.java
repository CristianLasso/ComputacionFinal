package com.taller1.CristianLasso.test.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taller1.CristianLasso.Taller1Application;
import com.taller1.CristianLasso.back.DAOs.AutotransitionDao;
import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.Eventstatus;
import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.repository.EventstatusRepository;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;
import com.taller1.CristianLasso.back.service.AutotransitionService;
import com.taller1.CristianLasso.back.service.AutotransitionServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
public class AutotransitionServiceTest {
	
	@Mock
	private AutotransitionDao autotranRepo;
	
	@Mock
	private FevInstitutionRepository instRepo;
	
	@Mock
	private EventstatusRepository eventRepo;
	
	@InjectMocks
	private AutotransitionService autotranService;
	
	@Autowired
	public AutotransitionServiceTest() {
		this.autotranService = new AutotransitionServiceImp(autotranRepo, instRepo, eventRepo);
	}
		
	@Test
	public void saveAutotransitionTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
			
		Autotransition autotranTest = (new Autotransition());
		autotranTest.get().setAutotranId(25);
		autotranTest.get().setAutotranName("VojabesTest");
		autotranTest.get().setInstInstId(instTest.get().getInstId());
		autotranTest.get().setEventstatus1(event1Test.get());
		autotranTest.get().setEventstatus2(event2Test.get());
		autotranTest.get().setAutotranIsactive("Y");
		autotranTest.get().setAutotranLogicaloperand("AND");
			
		when(autotranRepo.findById((long) 25)).thenReturn(autotranTest);
			
		assertEquals(autotranService.saveAutotransition(25, "Y", "AND", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()).getAutotranId(), autotranTest.get().getAutotranId());
		
	}
	
	@Test
	public void saveAutotransitionInvalidNameTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "Y", "AND", "", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveAutotransitionInvalidLogicalOperandTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "Y", "o", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveAutotransitionInvalidIsActiveTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "yes", "AND", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveAutotransitionInstitutionNullTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(null);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "Y", "AND", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveAutotransitionEventNullTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(null);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.saveAutotransition(25, "Y", "AND", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
			
		Autotransition autotranTest = (new Autotransition());
		autotranTest.get().setAutotranId(25);
		autotranTest.get().setAutotranName("VojabesTest");
		autotranTest.get().setInstInstId(instTest.get().getInstId());
		autotranTest.get().setEventstatus1(event1Test.get());
		autotranTest.get().setEventstatus2(event2Test.get());
		autotranTest.get().setAutotranIsactive("Y");
		autotranTest.get().setAutotranLogicaloperand("AND");
			
		when(autotranRepo.findById((long) 25)).thenReturn(autotranTest);
			
		assertEquals(autotranService.editAutotransition(25, "Y", "AND", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()).getAutotranId(), autotranTest.get().getAutotranId());
		
	}
	
	@Test
	public void editAutotransitionInvalidNameTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "Y", "AND", "", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionInvalidLogicalOperandTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "Y", "o", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionInvalidIsActiveTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "yes", "AND", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionInstitutionNullTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(null);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(event1Test);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "Y", "AND", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
	@Test
	public void editAutotransitionEventNullTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Optional<Eventstatus> event1Test = Optional.of(new Eventstatus());
		event1Test.get().setEvestatId(06);
		when(eventRepo.findById((long) 06)).thenReturn(null);
			
		Optional<Eventstatus> event2Test = Optional.of(new Eventstatus());
		event2Test.get().setEvestatId(25);
		when(eventRepo.findById((long) 25)).thenReturn(event2Test);
		
		assertThrows(RuntimeException.class, () -> autotranService.editAutotransition(25, "Y", "AND", "VojabesTest", instTest.get().getInstId(), event1Test.get().getEvestatId(), event2Test.get().getEvestatId()), "Exception not thrown");
		
	}
	
}
