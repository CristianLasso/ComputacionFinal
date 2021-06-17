package com.taller1.CristianLasso.back.service;


import com.taller1.CristianLasso.back.model.Localcondition;

public interface LocalconditionService {
	
	public Localcondition saveLocalcondition(long loconId, String loconColumnname, String loconKeycolumn, 
			String loconOperator, String loconQuerystring, String loconTablename, String loconValuetype,
			long precondition, long threshold);
	
	public Localcondition editLocalcondition(long loconId, String loconColumnname, String loconKeycolumn, 
			String loconOperator, String loconQuerystring, String loconTablename, String loconValuetype,
			long precondition, long threshold);
	
	public Iterable<Localcondition> findAll();
	
	public void save(Localcondition localcondition);
	
	public void delete(Localcondition localcondition);
	
	public Localcondition findById(long id);

}
