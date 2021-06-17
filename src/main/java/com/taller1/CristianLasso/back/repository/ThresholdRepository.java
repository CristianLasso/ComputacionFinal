package com.taller1.CristianLasso.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller1.CristianLasso.back.model.Threshold;

@Repository
public interface ThresholdRepository extends CrudRepository<Threshold, Long>{

}
