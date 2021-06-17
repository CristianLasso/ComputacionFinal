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
import com.taller1.CristianLasso.back.DAOs.ThresholdDao;
import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;
import com.taller1.CristianLasso.back.service.ThresholdService;
import com.taller1.CristianLasso.back.service.ThresholdServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
public class ThresholdServiceTest {

	@Mock
	private ThresholdDao thresRepo;
	
	@Mock
	private FevInstitutionRepository instRepo;
	
	@InjectMocks
	private ThresholdService thresService;
	
	@Autowired
	public ThresholdServiceTest() {
		this.thresService = new ThresholdServiceImp(thresRepo, instRepo);
	}
	
	@Test
	public void saveThresholdTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Threshold thresTest = (new Threshold());
		thresTest.get().setThresId(25);
		thresTest.get().setInstInstId(instTest.get().getInstId());
		thresTest.get().setThresName("VojabesTest");
		thresTest.get().setThresValue("Hi");
		thresTest.get().setThresValuetype("String");
			
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertEquals(thresService.saveThreshold(25, instTest.get().getInstId(), "VojabesTest", "Hi", "String").getThresId(), thresTest.get().getThresId());
			
	}
	
	@Test
	public void saveThresholdInvalidNameTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		assertThrows(RuntimeException.class, () -> thresService.saveThreshold(25, instTest.get().getInstId(), "", "Hi", "String"), "Exception not thrown");
			
	}
	
	@Test
	public void saveThresholdInvalidValueTypeTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		assertThrows(RuntimeException.class, () -> thresService.saveThreshold(25, instTest.get().getInstId(), "VojabesTest", "Hi", "buleano"), "Exception not thrown");
			
	}
	
	@Test
	public void saveThresholdInstitutionNullTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(null);
			
		assertThrows(RuntimeException.class, () -> thresService.saveThreshold(25, instTest.get().getInstId(), "VojabesTest", "Hi", "String"), "Exception not thrown");
			
	}
	
	@Test
	public void editThresholdTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		Threshold thresTest = (new Threshold());
		thresTest.get().setThresId(25);
		thresTest.get().setInstInstId(instTest.get().getInstId());
		thresTest.get().setThresName("VojabesTest");
		thresTest.get().setThresValue("Hi");
		thresTest.get().setThresValuetype("String");
			
		when(thresRepo.findById((long) 25)).thenReturn(thresTest);
			
		assertEquals(thresService.editThreshold(25, instTest.get().getInstId(), "VojabesTest", "Hi", "String").getThresId(), thresTest.get().getThresId());
			
	}
	
	@Test
	public void editThresholdInvalidNameTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		assertThrows(RuntimeException.class, () -> thresService.editThreshold(25, instTest.get().getInstId(), "", "Hi", "String"), "Exception not thrown");
			
	}
	
	@Test
	public void editThresholdInvalidValueTypeTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(instTest);
			
		assertThrows(RuntimeException.class, () -> thresService.editThreshold(25, instTest.get().getInstId(), "VojabesTest", "Hi", "buleano"), "Exception not thrown");
			
	}
	
	@Test
	public void editThresholdInstitutionNullTest() {
		
		Optional<FevInstitution> instTest = Optional.of(new FevInstitution());
		instTest.get().setInstId(25);
		when(instRepo.findById((long) 25)).thenReturn(null);
			
		assertThrows(RuntimeException.class, () -> thresService.editThreshold(25, instTest.get().getInstId(), "VojabesTest", "Hi", "String"), "Exception not thrown");
			
	}
	
}
