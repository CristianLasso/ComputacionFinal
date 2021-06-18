package com.taller1.CristianLasso.back.service;


import com.taller1.CristianLasso.back.model.Precondition;

public interface PreconditionService {

	public Precondition savePrecondition(long preconId, String preconLogicaloperand, long autotranId);
	
	public Precondition editPrecondition(long preconId, String preconLogicaloperand, long autotranId);
	
	public Iterable<Precondition> findAll();
	
	public void save(Precondition precondition);
	
	public void edit(Precondition precondition);
	
	public void delete(Precondition precondition);
	
	public Precondition findById(long id);
	
}
