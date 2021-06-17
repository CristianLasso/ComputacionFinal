package com.taller1.CristianLasso.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller1.CristianLasso.back.model.Eventstatus;

@Repository
public interface EventstatusRepository extends CrudRepository<Eventstatus, Long>{

}
