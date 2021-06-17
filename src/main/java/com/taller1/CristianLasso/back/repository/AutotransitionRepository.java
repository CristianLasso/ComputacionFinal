package com.taller1.CristianLasso.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller1.CristianLasso.back.model.Autotransition;

@Repository
public interface AutotransitionRepository extends CrudRepository<Autotransition, Long>{
	
}
