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
import com.taller1.CristianLasso.back.DAOs.PreconditionDao;
import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.repository.AutotransitionRepository;
import com.taller1.CristianLasso.back.service.PreconditionService;
import com.taller1.CristianLasso.back.service.PreconditionServiceImp;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
public class PreconditionServiceTest {
	
	@Mock
	private PreconditionDao preconRepo;
	
	@Mock
	private AutotransitionRepository autotranRepo;
	
	@InjectMocks
	private PreconditionService preconService;
	
	@Autowired
	public PreconditionServiceTest() {
		this.preconService = new PreconditionServiceImp(preconRepo, autotranRepo);
	}

		
	@Test
	public void savePreconditionTest() {
		
		Optional<Autotransition> autotranTest = Optional.of(new Autotransition());
		autotranTest.get().setAutotranId(25);
		when(autotranRepo.findById((long) 25)).thenReturn(autotranTest);
			
		Precondition preconTest = (new Precondition());
		preconTest.get().setPreconId(25);
		preconTest.get().setPreconLogicaloperand("AND");
		preconTest.get().setAutotransition(autotranTest.get());
			
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
			
		assertEquals(preconService.savePrecondition(25, "AND", autotranTest.get().getAutotranId()).getPreconId(), preconTest.get().getPreconId());
			
	}
	
	@Test
	public void savePreconditionInvalidLogicalOperandTest() {
		
		Optional<Autotransition> autotranTest = Optional.of(new Autotransition());
		autotranTest.get().setAutotranId(25);
		when(autotranRepo.findById((long) 25)).thenReturn(autotranTest);
			
		assertThrows(RuntimeException.class, () -> preconService.savePrecondition(25, "o", autotranTest.get().getAutotranId()), "Exception not thrown");
			
	}
	
	@Test
	public void savePreconditionAutotransitionNullTest() {
		
		Optional<Autotransition> autotranTest = Optional.of(new Autotransition());
		autotranTest.get().setAutotranId(25);
		when(autotranRepo.findById((long) 25)).thenReturn(null);
			
		assertThrows(RuntimeException.class, () -> preconService.savePrecondition(25, "AND", autotranTest.get().getAutotranId()), "Exception not thrown");
			
	}
	
	@Test
	public void editPreconditionTest() {
		
		Optional<Autotransition> autotranTest = Optional.of(new Autotransition());
		autotranTest.get().setAutotranId(25);
		when(autotranRepo.findById((long) 25)).thenReturn(autotranTest);
			
		Precondition preconTest = (new Precondition());
		preconTest.get().setPreconId(25);
		preconTest.get().setPreconLogicaloperand("AND");
		preconTest.get().setAutotransition(autotranTest.get());
			
		when(preconRepo.findById((long) 25)).thenReturn(preconTest);
			
		assertEquals(preconService.editPrecondition(25, "AND", autotranTest.get().getAutotranId()).getPreconId(), preconTest.get().getPreconId());
			
	}
	
	@Test
	public void editPreconditionInvalidLogicalOperandTest() {
		
		Optional<Autotransition> autotranTest = Optional.of(new Autotransition());
		autotranTest.get().setAutotranId(25);
		when(autotranRepo.findById((long) 25)).thenReturn(autotranTest);
			
		assertThrows(RuntimeException.class, () -> preconService.editPrecondition(25, "o", autotranTest.get().getAutotranId()), "Exception not thrown");
			
	}
	
	@Test
	public void editPreconditionAutotransitionNullTest() {
		
		Optional<Autotransition> autotranTest = Optional.of(new Autotransition());
		autotranTest.get().setAutotranId(25);
		when(autotranRepo.findById((long) 25)).thenReturn(null);
			
		assertThrows(RuntimeException.class, () -> preconService.editPrecondition(25, "AND", autotranTest.get().getAutotranId()), "Exception not thrown");
			
	}
	
}

