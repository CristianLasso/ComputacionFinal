package com.taller1.CristianLasso.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller1.CristianLasso.back.model.FevInstitution;

@Repository
public interface FevInstitutionRepository extends CrudRepository<FevInstitution, Long>{
	
}
