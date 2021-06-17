package com.taller1.CristianLasso.back.service;


import com.taller1.CristianLasso.back.model.Threshold;

public interface ThresholdService {
	
	public Threshold saveThreshold(long thresId, long instInstId, String thresName, String thresValue, String thresValuetype);
	
	public Threshold editThreshold(long thresId, long instInstId, String thresName, String thresValue, String thresValuetype);
	
	public Iterable<Threshold> findAll();
	
	public void save(Threshold threshold);
	
	public void delete(Threshold threshold);
	
	public Threshold findById(long id);

}
