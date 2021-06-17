package com.taller1.CristianLasso.back.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller1.CristianLasso.back.model.Userr;


@Repository
public interface UserrRepository extends CrudRepository<Userr, Long>{
	Optional<Userr> findByUserName(String username);
}