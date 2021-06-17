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
import com.taller1.CristianLasso.back.DAOs.LocalconditionDao;
import com.taller1.CristianLasso.back.model.Localcondition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.repository.PreconditionRepository;
import com.taller1.CristianLasso.back.repository.ThresholdRepository;
import com.taller1.CristianLasso.back.service.LocalconditionService;
import com.taller1.CristianLasso.back.service.LocalconditionServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
public class LocalconditionServiceTest {
	
	@Mock
	private LocalconditionDao localRepo;
	
	@Mock
	private PreconditionRepository preconRepo;
	
	@Mock
	private ThresholdRepository thresRepo;
	
	@InjectMocks
	private LocalconditionService localService;
	
	@Autowired
	public LocalconditionServiceTest() {
		this.localService = new LocalconditionServiceImp(localRepo, preconRepo, thresRepo);
	}
	
	@Test
	public void saveLocalconditonTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		Localcondition localTest = (new Localcondition());
		localTest.get().setLoconId(25);
		localTest.get().setLoconColumnname("VojabesTest");
		localTest.get().setLoconKeycolumn("KeyTest");
		localTest.get().setLoconOperator("<>");
		localTest.get().setLoconQuerystring("QueryTest");
		localTest.get().setLoconTablename("TableTest");
		localTest.get().setLoconValuetype("TypeTest");
		localTest.get().setPrecondition(preconTest.get());
		localTest.get().setThreshold(thresTest.get());
			
		when(localRepo.findById((long) 25)).thenReturn(localTest);
			
		assertEquals(localService.saveLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()).getLoconId(), localTest.get().getLoconId());
			
	}
	
	@Test
	public void saveLocalconditonInvalidTableNameTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "Table Test", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void saveLocalconditonInvalidKeyColumnTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "Key Test", "<>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void saveLocalconditonInvalidColumnNameTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "Vojabes Test", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void saveLocalconditonInvalidOperatorTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "KeyTest", ">>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void saveLocalconditonPreconditionNullTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(null);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "KeyTest", ">>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void saveLocalconditonThresholdnNullTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(null);
			
		assertThrows(RuntimeException.class, () -> localService.saveLocalcondition(25, "VojabesTest", "KeyTest", ">>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void editLocalconditonTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		Localcondition localTest = (new Localcondition());
		localTest.get().setLoconId(25);
		localTest.get().setLoconColumnname("VojabesTest");
		localTest.get().setLoconKeycolumn("KeyTest");
		localTest.get().setLoconOperator("<>");
		localTest.get().setLoconQuerystring("QueryTest");
		localTest.get().setLoconTablename("TableTest");
		localTest.get().setLoconValuetype("TypeTest");
		localTest.get().setPrecondition(preconTest.get());
		localTest.get().setThreshold(thresTest.get());
			
		when(localRepo.findById((long) 25)).thenReturn(localTest);
			
		assertEquals(localService.editLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()).getLoconId(), localTest.get().getLoconId());
			
	}
	
	@Test
	public void editLocalconditonInvalidTableNameTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "KeyTest", "<>", "QueryTest", "Table Test", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void editLocalconditonInvalidKeyColumnTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "Key Test", "<>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void editLocalconditonInvalidColumnNameTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "Vojabes Test", "KeyTest", "<>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void editLocalconditonInvalidOperatorTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "KeyTest", ">>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void editLocalconditonPreconditionNullTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(null);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "KeyTest", ">>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}
	
	@Test
	public void editLocalconditonThresholdnNullTest() {
		
		Optional<Precondition> preconTest = Optional.of(new Precondition());
		preconTest.get().setPreconId(25);
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
		
		Optional<Threshold> thresTest = Optional.of(new Threshold());
		thresTest.get().setThresId(25);
		when(thresRepo.findById((long) 25)).thenReturn(null);
			
		assertThrows(RuntimeException.class, () -> localService.editLocalcondition(25, "VojabesTest", "KeyTest", ">>", "QueryTest", "TableTest", "TypeTest", preconTest.get().getPreconId(), thresTest.get().getThresId()), "Exception not thrown");
			
	}

}
