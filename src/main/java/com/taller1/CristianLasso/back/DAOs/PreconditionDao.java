package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import com.taller1.CristianLasso.back.model.Precondition;

public interface PreconditionDao {
	
	void save(Precondition entity);

	void delete(Precondition entity);

	void edit(Precondition entity);

	Precondition findById(long id);
	
	List<Precondition>  findAll();

}
