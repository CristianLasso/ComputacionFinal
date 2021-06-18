package com.taller1.CristianLasso.back.service;

import java.math.BigDecimal;
import java.util.Date;

import com.taller1.CristianLasso.back.model.Symptom;

public interface SymptomService {
	
	public Symptom saveSymptom(long sympId, String sympIsactive, 
			String sympName);
	
	public Symptom editSymptom(long sympId, String sympIsactive, 
			String sympName);
	
	public Iterable<Symptom> findAll();
	
	public void save(Symptom symptom);
	
	public void delete(Symptom symptom);
	
	public Symptom findById(long id);


}
