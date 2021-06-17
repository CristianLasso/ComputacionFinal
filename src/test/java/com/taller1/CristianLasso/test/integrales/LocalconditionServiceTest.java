package com.taller1.CristianLasso.test.integrales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taller1.CristianLasso.back.model.Localcondition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.repository.LocalconditionRepository;
import com.taller1.CristianLasso.back.repository.PreconditionRepository;
import com.taller1.CristianLasso.back.repository.ThresholdRepository;
import com.taller1.CristianLasso.back.service.LocalconditionServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LocalconditionServiceTest {

	private LocalconditionRepository localRepo;
	private PreconditionRepository preconRepo;
	private ThresholdRepository thresRepo;
	private LocalconditionServiceImp localService;
	
	@Autowired
	public LocalconditionServiceTest(LocalconditionRepository localRepo, PreconditionRepository preconRepo,ThresholdRepository thresRepo, LocalconditionServiceImp localService) {
		this.localRepo = localRepo;
		this.preconRepo = preconRepo;
		this.thresRepo = thresRepo;
		this.localService = localService;
	}
	
	public Localcondition setUp1() {
		Localcondition local = new Localcondition();
		localRepo.save(local);
		return local;
	}
	
	public Precondition setUp2() {
		Precondition precon = new Precondition();
		preconRepo.save(precon);
		return precon;
	}
	
	public Threshold setUp3() {
		Threshold thres = new Threshold();
		thresRepo.save(thres);
		return thres;
	}
	
	@Test
	public void saveLocalconditonTest() {
		
		Localcondition local = setUp1();
		local.setLoconId(25);
		local.setLoconColumnname("VojabesTest");
		local.setLoconKeycolumn("KeyTest");
		local.setLoconOperator("<>");
		local.setLoconQuerystring("QueryTest");
		local.setLoconTablename("TableTest");
		local.setLoconValuetype("TypeTest");
		local.setPrecondition(setUp2());
		local.setThreshold(setUp3());
		
		assertEquals(localService.saveLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()).getLoconId(), local.getLoconId());
		
	}
	
	@Test
	public void saveLocalconditionInvalidTableNameTest() {
		
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "Table Test", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveLocalconditonInvalidKeyColumnTest() {
		
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "Key Test", "<>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveLocalconditonInvalidColumnNameTest() {
		
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "Vojabes Test", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveLocalconditonInvalidOperatorTest() {
		
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "KeyTest", ">>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveLocalconditonPreconditionNullTest() {
		
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", 0, setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void saveLocalconditonThresholdNullTest() {
		
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), 0), "Exception not thrown");
		
	}
	
	@Test
	public void editLocalconditionInvalidTableNameTest() {
		
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "Table Test", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void editLocalconditonInvalidKeyColumnTest() {
		
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "Key Test", "<>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void editLocalconditonInvalidColumnNameTest() {
		
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "Vojabes Test", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void editLocalconditonInvalidOperatorTest() {
		
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "KeyTest", ">>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void editLocalconditonPreconditionNullTest() {
		
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", 0, setUp3().getThresId()), "Exception not thrown");
		
	}
	
	@Test
	public void editLocalconditonThresholdNullTest() {
		
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", setUp2().getPreconId(), 0), "Exception not thrown");
		
	}
	
}
