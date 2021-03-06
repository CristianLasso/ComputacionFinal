package com.taller1.CristianLasso.back.service;


import com.taller1.CristianLasso.back.model.Autotransition;

public interface AutotransitionService {
	
	public Autotransition saveAutotransition(long autotranId, String autotranIsactive, 
			String autotranLogicaloperand, String autotranName, long instId, 
			long event1Id, long event2Id);
	
	public Autotransition editAutotransition(Autotransition autotransition);
	
	public Iterable<Autotransition> findAll();
	
	public void save(Autotransition autotransition);
	
	public void edit(Autotransition autotransition);
	
	public void delete(Autotransition autotransition);
	
	public Autotransition findById(long id);
	
}
