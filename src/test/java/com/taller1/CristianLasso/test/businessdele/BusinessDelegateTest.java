package com.taller1.CristianLasso.test.businessdele;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;
import com.taller1.CristianLasso.front.model.Autotransition;
import com.taller1.CristianLasso.front.model.FevInstitution;
import com.taller1.CristianLasso.front.model.Localcondition;
import com.taller1.CristianLasso.front.model.Precondition;
import com.taller1.CristianLasso.front.model.Symptom;
import com.taller1.CristianLasso.front.model.Symptompoll;
import com.taller1.CristianLasso.front.model.Symptomquestion;
import com.taller1.CristianLasso.front.model.Threshold;

@SpringBootTest
class BusinessDelegateTest {

	@Mock
	private BusinessDelegateImp businessDelegateImp;
	
	public BusinessDelegateTest() {
		// TODO Auto-generated constructor stub
		this.businessDelegateImp = businessDelegateImp;
		
	}
	/*
	 *										SAVE TESTS START
	 * 
	 */
	
	@Test
	void autotranSaveTest() {
		Autotransition genericAutotransition = new Autotransition();
		genericAutotransition.setAutotranId(1L);
		when(businessDelegateImp.autotranFinById(1L)).thenReturn(genericAutotransition);
		businessDelegateImp.autotranSave(genericAutotransition);
		assertEquals(businessDelegateImp.autotranFinById(1L).getAutotranId(), genericAutotransition.getAutotranId(),"The ID should be 1");
	}
	
	@Test 
	void instiSaveTest() {
		FevInstitution genericInstitution = new FevInstitution();
		genericInstitution.setInstId(1L);
		
		when(businessDelegateImp.instiFinById(1L)).thenReturn(genericInstitution);
		businessDelegateImp.instiSave(genericInstitution);
		assertEquals(businessDelegateImp.instiFinById(1L).getInstId(), genericInstitution.getInstId(),"The ID should be 1");
	}
	
	
	@Test
	void saveLocalTest() {
		Localcondition genericLocal = new Localcondition();
		genericLocal.setLoconId(1);
		when(businessDelegateImp.localFinById(1)).thenReturn(genericLocal);
		businessDelegateImp.localSave(genericLocal);
		assertEquals(businessDelegateImp.localFinById(1).getLoconId(), genericLocal.getLoconId(),"The ID should be 1");
	}
	
	
	@Test
	void preconSaveTest() {
		
		Precondition genericPrecon = new Precondition();
		genericPrecon.setPreconId(1);
		when(businessDelegateImp.preconFinById(1)).thenReturn(genericPrecon);
		businessDelegateImp.preconSave(genericPrecon);
		assertEquals(businessDelegateImp.preconFinById(1).getPreconId(),genericPrecon.getPreconId(),"The ID should be 1");
		
	}
	
	@Test
	void thresSaveTest() {
		
		Threshold genericThres = new Threshold();
		genericThres.setThresId(1);
		when(businessDelegateImp.thresFinById(1)).thenReturn(genericThres);
		businessDelegateImp.thresSave(genericThres);
		assertEquals(businessDelegateImp.thresFinById(1).getThresId(),genericThres.getThresId(),"The ID should be 1");
		
	}
	
	@Test
	void symptomSaveTest() {
		
		Symptom genericSymptom = new Symptom();
		genericSymptom.setSympId(1);
		when(businessDelegateImp.symptomFinById(1)).thenReturn(genericSymptom);
		businessDelegateImp.symptomSave(genericSymptom);
		assertEquals(businessDelegateImp.symptomFinById(1).getSympId(),genericSymptom.getSympId(),"The ID should be 1");
	}

	@Test
	void symptompollSave() {
		Symptompoll genericSymptompoll = new Symptompoll();
		genericSymptompoll.setSympollId(1);
		when(businessDelegateImp.symptompollFinById(1)).thenReturn(genericSymptompoll);
		businessDelegateImp.symptompollSave(genericSymptompoll);
		assertEquals(businessDelegateImp.symptompollFinById(1).getSympollId(),genericSymptompoll.getSympollId(),"The ID should be 1");
	}
	
	@Test
	void symptomquestionSave(){
		Symptomquestion genericSymptomquestion = new Symptomquestion();
		genericSymptomquestion.setSympquesId(1);
		when(businessDelegateImp.symptomquestionFinById(1)).thenReturn(genericSymptomquestion);
		businessDelegateImp.symptomquestionSave(genericSymptomquestion);
	}
	
	/*
	 *										SAVE TESTS END
	 * 
	 */
	
	/*
	 *										EDIT TESTS START
	 * 
	 */
	
	@Test
	void autotranEditTest() {
		Autotransition genericAuto = new Autotransition();
		genericAuto.setAutotranId(1);
		genericAuto.setAutotranName("prueba");
		when(businessDelegateImp.autotranFinById(1)).thenReturn(genericAuto);
		businessDelegateImp.autotranSave(genericAuto);
		businessDelegateImp.autotranEdit(genericAuto);
		assertNotEquals("prueba1", businessDelegateImp.autotranFinById(1).getAutotranId(), "The attribute not are the same");
		
	}
	
	@Test
	void instiEditTest() {
		FevInstitution genericAuto = new FevInstitution();
		genericAuto.setInstId(1);
		genericAuto.setInstName("prueba");
		when(businessDelegateImp.instiFinById(1)).thenReturn(genericAuto);
		businessDelegateImp.instiSave(genericAuto);
		businessDelegateImp.instiEdit(genericAuto);
		assertNotEquals("prueba1", businessDelegateImp.instiFinById(1).getInstId(), "The attribute not are the same");
		
	}
	
	@Test
	void localEditTest() {
		Localcondition genericAuto = new Localcondition();
		genericAuto.setLoconId(1);
		genericAuto.setLoconTablename("prueba");
		when(businessDelegateImp.localFinById(1)).thenReturn(genericAuto);
		businessDelegateImp.localSave(genericAuto);
		businessDelegateImp.localEdit(genericAuto);
		assertNotEquals("prueba1", businessDelegateImp.localFinById(1).getLoconId(), "The attribute not are the same");
		
	}
	
	@Test
	void preconEditTest() {
		Precondition genericAuto = new Precondition();
		genericAuto.setPreconId(1);
		genericAuto.setPreconLogicaloperand("prueba");
		when(businessDelegateImp.preconFinById(1)).thenReturn(genericAuto);
		businessDelegateImp.preconSave(genericAuto);
		businessDelegateImp.preconEdit(genericAuto);
		assertNotEquals("prueba1", businessDelegateImp.preconFinById(1).getPreconId(), "The attribute not are the same");
		
	}
	
	@Test
	void thresEditTest() {
		Threshold genericAuto = new Threshold();
		genericAuto.setThresId(1);
		genericAuto.setThresName("prueba");
		when(businessDelegateImp.thresFinById(1)).thenReturn(genericAuto);
		businessDelegateImp.thresSave(genericAuto);
		businessDelegateImp.thresEdit(genericAuto);
		assertNotEquals("prueba1", businessDelegateImp.thresFinById(1).getThresId(), "The attribute not are the same");
		
	}
	
	@Test
	void symptomEditTest() {
		Symptom genericAuto = new Symptom();
		genericAuto.setSympId(1);
		genericAuto.setSympName("prueba");
		when(businessDelegateImp.symptomFinById(1)).thenReturn(genericAuto);
		businessDelegateImp.symptomSave(genericAuto);
		businessDelegateImp.symptomEdit(genericAuto);
		assertNotEquals("prueba1", businessDelegateImp.symptomFinById(1).getSympId(), "The attribute not are the same");
		
	}
	
	@Test
	void symptompollEditTest() {
		Symptompoll genericAuto = new Symptompoll();
		genericAuto.setSympollId(1);
		genericAuto.setSympollName("prueba");
		when(businessDelegateImp.symptompollFinById(1)).thenReturn(genericAuto);
		businessDelegateImp.symptompollSave(genericAuto);
		businessDelegateImp.symptompollEdit(genericAuto);
		assertNotEquals("prueba1", businessDelegateImp.symptompollFinById(1).getSympollId(), "The attribute not are the same");
		
	}
	
	@Test
	void symptomquestionEditTest() {
		Symptomquestion genericAuto = new Symptomquestion();
		genericAuto.setSympquesId(1);
		genericAuto.setSympquesName("prueba");
		when(businessDelegateImp.symptomquestionFinById(1)).thenReturn(genericAuto);
		businessDelegateImp.symptomquestionSave(genericAuto);
		businessDelegateImp.symptomquestionEdit(genericAuto);
		assertNotEquals("prueba1", businessDelegateImp.symptomquestionFinById(1).getSympquesId(), "The attribute not are the same");
		
	}
}

