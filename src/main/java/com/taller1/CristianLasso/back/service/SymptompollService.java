package com.taller1.CristianLasso.back.service;

import java.math.BigDecimal;
import java.util.Date;

import com.taller1.CristianLasso.back.model.Symptompoll;

public interface SymptompollService {
	
	
	public Symptompoll saveSymptompoll(long sympollId, BigDecimal instInstId, 
			Date sympollEnddate, String sympollName, Date sympollStartdate);
	
	public Symptompoll editSymptompoll(long sympollId, BigDecimal instInstId, 
			Date sympollEnddate, String sympollName, Date sympollStartdate);
	
	public Iterable<Symptompoll> findAll();
	
	public void save(Symptompoll symptompoll);
	
	public void delete(Symptompoll symptompoll);
	
	public Symptompoll findById(long id);

}
