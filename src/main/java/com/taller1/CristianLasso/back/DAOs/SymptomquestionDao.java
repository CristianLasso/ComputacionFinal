package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import com.taller1.CristianLasso.back.model.Symptomquestion;

public interface SymptomquestionDao {
	
	public Symptomquestion save(Symptomquestion Symptomquestion);
	public Symptomquestion update(Symptomquestion Symptomquestion);
	public void delete(Symptomquestion Symptomquestion);
	public List<Symptomquestion> findAll();
	public Symptomquestion findById(long id);
	
}
