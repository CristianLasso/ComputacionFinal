package com.taller1.CristianLasso.back.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.taller1.CristianLasso.back.model.Symptompoll;
import com.taller1.CristianLasso.back.model.Symptomquestion;



public interface SymptomquestionService {
	
	
	//relacion sympthom
	public Symptomquestion saveSymptomquestion(long sympquesId, String sympquesActivationanswer, 
			 String sympquesIsactive, String sympquesName,BigDecimal sympquesWeight);
	
	
	public Symptomquestion editSymptomquestion(long sympquesId, String sympquesActivationanswer, String sympquesIsactive,
			String sympquesName, BigDecimal sympquesWeight);

	
	public void save(Symptomquestion Symptomquestion);

	public void delete(Symptomquestion Symptomquestion);
	public List<Symptomquestion> findAll();
	public Symptomquestion findById(long sympollId);
	
	
}
