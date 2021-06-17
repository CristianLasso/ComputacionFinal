package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import com.taller1.CristianLasso.back.model.Threshold;

public interface ThresholdDao {
	
	void save(Threshold entity);

	void delete(Threshold entity);

	void edit(Threshold entity);

	Threshold findById(long id);
	
	List<Threshold>  findAll();
	
	List<Threshold> findByName(String name);
	
	List<Threshold> findByValue(String thresValue);

	List<Threshold> findByValuetype(String thresValuetype);

}
