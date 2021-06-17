package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import com.taller1.CristianLasso.back.model.Localcondition;

public interface LocalconditionDao {
	
	void save(Localcondition entity);

	void delete(Localcondition entity);

	void edit(Localcondition entity);

	Localcondition findById(long id);
	
	List<Localcondition>  findAll();
	
	List<Localcondition> findByName(String name);

	List<Localcondition> findByValuetype(String loconValuetype);

}
