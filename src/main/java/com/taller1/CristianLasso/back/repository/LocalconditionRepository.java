package com.taller1.CristianLasso.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller1.CristianLasso.back.model.Localcondition;

@Repository
public interface LocalconditionRepository extends CrudRepository<Localcondition, Long>{

}
