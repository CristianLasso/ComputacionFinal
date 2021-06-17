package com.taller1.CristianLasso.back.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;

@Service
public class FevInstitutionServiceImp implements FevInstitutionService {
	private FevInstitutionRepository fevInstitutionRepository;
	
	@Autowired
	public FevInstitutionServiceImp(FevInstitutionRepository fevInstitutionRepository) {
		this.fevInstitutionRepository = fevInstitutionRepository;
	}
	
	@Override
	public Iterable<FevInstitution> findAll() {
		return fevInstitutionRepository.findAll();
	}
	
	@Override
	public FevInstitution save(FevInstitution fevInstitution) {
		return fevInstitutionRepository.save(fevInstitution);
	}
	
	@Override
	public Optional<FevInstitution> findById(long id) {
		return fevInstitutionRepository.findById(id);
	}

	@Override
	public void delete(FevInstitution fevInstitution) {
		fevInstitutionRepository.delete(fevInstitution);
	}
	
}