package com.taller1.CristianLasso.test.integrales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;
import com.taller1.CristianLasso.back.repository.ThresholdRepository;
import com.taller1.CristianLasso.back.service.ThresholdServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ThresholdServiceTest {

	private ThresholdRepository thresRepo;
	private FevInstitutionRepository instRepo;
	private ThresholdServiceImp thresService;
	
	@Autowired
	public ThresholdServiceTest(ThresholdRepository thresRepo, FevInstitutionRepository instRepo, ThresholdServiceImp thresService) {
		this.thresRepo = thresRepo;
		this.instRepo = instRepo;
		this.thresService = thresService;
	}
	
	public Threshold setUp1() {
		Threshold thres = new Threshold();
		thresRepo.save(thres);
		return thres;
	}
	
	public FevInstitution setUp2() {
		FevInstitution inst = new FevInstitution();
		instRepo.save(inst);
		return inst;
	}
	
	@Test
	public void saveThresholdTest() {
		
		Threshold thres = new Threshold();
		thres.setThresId(25);
		thres.setInstInstId(setUp2().getInstId());
		thres.setThresName("VojabesTest");
		thres.setThresValue("Hi");
		thres.setThresValuetype("String");
		
		assertEquals(thresService.saveThreshold(25, setUp2().getInstId(), "VojabesTest", "Hi", "String").getThresId(), thres.getThresId());
		
	}
	
	@Test
	public void saveThresholdInvalidNameTest() {
		
		assertThrows(RuntimeException.class, () -> thresService.saveThreshold(25, setUp2().getInstId(), "", "Hi", "String"), "Exception not thrown");
		
	}
	
	@Test
	public void saveThresholdInvalidValueTypeTest() {
		
		assertThrows(RuntimeException.class, () -> thresService.saveThreshold(25, setUp2().getInstId(), "VojabesTest", "Hi", "buleano"), "Exception not thrown");
		
	}
	
	@Test
	public void saveThresholdInstitutionNullTest() {
		
		assertThrows(RuntimeException.class, () -> thresService.saveThreshold(25, 0, "VojabesTest", "Hi", "String"), "Exception not thrown");
		
	}
	
	@Test
	public void editThresholdInvalidNameTest() {
		
		assertThrows(RuntimeException.class, () -> thresService.editThreshold(25, setUp2().getInstId(), "", "Hi", "String"), "Exception not thrown");
		
	}
	
	@Test
	public void editThresholdInvalidValueTypeTest() {
		
		assertThrows(RuntimeException.class, () -> thresService.editThreshold(25, setUp2().getInstId(), "VojabesTest", "Hi", "buleano"), "Exception not thrown");
		
	}
	
	@Test
	public void editThresholdInstitutionNullTest() {
		
		assertThrows(RuntimeException.class, () -> thresService.editThreshold(25, 0, "VojabesTest", "Hi", "String"), "Exception not thrown");
		
	}
	
}
