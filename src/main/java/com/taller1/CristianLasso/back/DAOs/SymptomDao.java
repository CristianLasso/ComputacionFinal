package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import com.taller1.CristianLasso.back.model.Symptom;

public interface SymptomDao {
	public Symptom save(Symptom Symptom);
	public Symptom update(Symptom Symptom);
	public void delete(Symptom Symptom);
	public List<Symptom> findAll();
	public Symptom findById(long id);
}
