package com.taller1.CristianLasso.test.integrales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.repository.AutotransitionRepository;
import com.taller1.CristianLasso.back.repository.PreconditionRepository;
import com.taller1.CristianLasso.back.service.PreconditionServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PreconditionServiceTest {
	
	private PreconditionRepository preconRepo;
	private AutotransitionRepository autotranRepo;
	private PreconditionServiceImp preconService;
	
	@Autowired
	public PreconditionServiceTest(PreconditionRepository preconRepo, AutotransitionRepository autotranRepo, PreconditionServiceImp preconService) {
		this.preconRepo = preconRepo;
		this.autotranRepo = autotranRepo;
		this.preconService = preconService;
	}
	
	public Precondition setUp1() {
		Precondition precon = new Precondition();
		preconRepo.save(precon);
		return precon;
	}
	
	public Autotransition setUp2() {
		Autotransition auto = new Autotransition();
		autotranRepo.save(auto);
		return auto;
	}
	
	@Test
	public void savePreconditionTest() {
		
		Precondition precon = setUp1();
		precon.setPreconId(25);
		precon.setPreconLogicaloperand("AND");
		precon.setAutotransition(setUp2());
		
		assertEquals(preconService.savePrecondition(25, "AND", setUp2().getAutotranId()).getPreconId(), precon.getPreconId());
		
	}
	
	@Test
	public void savePreconditionInvalidLogicalOperandTest() {
		
		assertThrows(RuntimeException.class, () -> preconService.savePrecondition(25, "o", setUp2().getAutotranId()), "Exception not thrown");
		
	}
	
	@Test
	public void savePreconditionAutotransitionNullTest() {
		
		assertThrows(RuntimeException.class, () -> preconService.savePrecondition(25, "AND", 0), "Exception not thrown");
		
	}
	
	@Test
	public void editPreconditionInvalidLogicalOperandTest() {
		
		assertThrows(RuntimeException.class, () -> preconService.editPrecondition(25, "o", setUp2().getAutotranId()), "Exception not thrown");
		
	}
	
	@Test
	public void editPreconditionAutotransitionNullTest() {
		
		assertThrows(RuntimeException.class, () -> preconService.editPrecondition(25, "AND", 0), "Exception not thrown");
		
	}

}
