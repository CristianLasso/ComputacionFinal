package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import com.taller1.CristianLasso.back.model.Autotransition;

public interface AutotransitionDao {

	void save(Autotransition entity);

	void delete(Autotransition entity);

	void edit(Autotransition entity);

	Autotransition findById(long id);
	
	List<Autotransition>  findAll();

	List<Autotransition> findByName(String name);
	
	List<Autotransition> findByInstId(long instInstId);

	List<Autotransition> findByActive(String isActive);
	
	List<Autotransition> findByAnd();

}
