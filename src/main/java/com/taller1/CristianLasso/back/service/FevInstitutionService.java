package com.taller1.CristianLasso.back.service;

import java.util.Optional;

import com.taller1.CristianLasso.back.model.FevInstitution;

public interface FevInstitutionService {

	public Iterable<FevInstitution> findAll();
	
	public FevInstitution save(FevInstitution fevInstitution);
	
	public void delete(FevInstitution fevInstitution);
	
	public Optional<FevInstitution> findById(long id);
}