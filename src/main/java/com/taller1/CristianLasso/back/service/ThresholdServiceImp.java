package com.taller1.CristianLasso.back.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.DAOs.ThresholdDao;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;

@Service
public class ThresholdServiceImp implements ThresholdService{

	private ThresholdDao thresDao;
	private FevInstitutionRepository instRepo;
	
	@Autowired
	public ThresholdServiceImp(ThresholdDao thresRepo, FevInstitutionRepository instRepo) {
		this.thresDao = thresRepo;
		this.instRepo = instRepo;
	}
	
	@Override
	public Threshold saveThreshold(long thresId, long instInstId, String thresName, String thresValue,
			String thresValuetype) throws RuntimeException {
		// TODO Auto-generated method stub
		if (thresName.equalsIgnoreCase("") || thresValue.equalsIgnoreCase("")) {
			throw new RuntimeException();
		}
		
		if (!(thresValuetype.equalsIgnoreCase("String") ||
				thresValuetype.equalsIgnoreCase("Int") ||
				thresValuetype.equalsIgnoreCase("Float") ||
				thresValuetype.equalsIgnoreCase("Boolean") ||
				thresValuetype.equalsIgnoreCase("Char"))) {
			throw new RuntimeException();
		}
		
		if (instRepo.findById(instInstId).isEmpty()) {
			throw new RuntimeException();
		}
		
		Threshold thres = new Threshold();
		thres.setThresId(thresId);
		thres.setInstInstId(instInstId);
		thres.setThresName(thresName);
		thres.setThresValue(thresValue);
		thres.setThresValuetype(thresValuetype);
		
		thresDao.save(thres);
		return thres;
	}

	@Override
	public Threshold editThreshold(long thresId, long instInstId, String thresName, String thresValue,
			String thresValuetype) throws RuntimeException {
		// TODO Auto-generated method stub
		if (thresName.equalsIgnoreCase("") || thresValue.equalsIgnoreCase("")) {
			throw new RuntimeException();
		}
		
		if (!(thresValuetype.equalsIgnoreCase("String") ||
				thresValuetype.equalsIgnoreCase("Int") ||
				thresValuetype.equalsIgnoreCase("Float") ||
				thresValuetype.equalsIgnoreCase("Boolean") ||
				thresValuetype.equalsIgnoreCase("Char"))) {
			throw new RuntimeException();
		}
		
		if (instRepo.findById(instInstId).isEmpty()) {
			throw new RuntimeException();
		}
		
		Threshold newThres = thresDao.findById(thresId).get();
		newThres.setInstInstId(instInstId);
		newThres.setThresName(thresName);
		newThres.setThresValue(thresValue);
		newThres.setThresValuetype(thresValuetype);
		
		thresDao.delete(newThres);
		thresDao.save(newThres);
		return newThres;
	}
	
	@Override
	public Iterable<Threshold> findAll() {
		return thresDao.findAll();
	}

	@Override
	public void save(Threshold threshold) {
		thresDao.save(threshold);
	}

	@Override
	public Threshold findById(long id) {
		return thresDao.findById(id);
	}

	@Override
	public void delete(Threshold threshold) {
		thresDao.delete(threshold);
	}

}
