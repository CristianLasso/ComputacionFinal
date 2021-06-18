package com.taller1.CristianLasso.back.service;


import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.DAOs.SymptomDao;
import com.taller1.CristianLasso.back.model.Symptom;

@Service
public class SymptomServiceImp implements SymptomService{
 
	private SymptomDao symptomDao;
	
	@Autowired
	public  SymptomServiceImp(SymptomDao symptomDao ) {
		// TODO Auto-generated constructor stub
		this.symptomDao = symptomDao;
	}
	
	@Override
	public Symptom saveSymptom(long sympId, String sympIsactive, String sympName) {
		
		Symptom sympton = new Symptom();
		sympton.setSympId(sympId);
		sympton.setSympIsactive(sympIsactive);
		sympton.setSympName(sympName);
		
		return sympton;
	}

	@Override
	public Symptom editSymptom(long sympId, String sympIsactive, String sympName) {
		// TODO Auto-generated method stub
		
		Symptom sympton = symptomDao.findById(sympId);
		sympton.setSympIsactive(sympIsactive);
		sympton.setSympName(sympName);
		symptomDao.delete(sympton);
		symptomDao.save(sympton);
		return sympton;
	}

	@Override
	public Iterable<Symptom> findAll() {
		// TODO Auto-generated method stub
		return symptomDao.findAll();
	}

	@Override
	public void save(Symptom symptom) {
		// TODO Auto-generated method stub
		symptomDao.save(symptom);
	}
	
	@Override
	public void update(Symptom symptom) {
		symptomDao.update(symptom);
	}

	@Override
	public void delete(Symptom symptom) {
		// TODO Auto-generated method stub
		symptomDao.delete(symptom);
	}

	@Override
	public Symptom findById(long id) {
		// TODO Auto-generated method stub
		return symptomDao.findById(id);
	}
	
	
	
}
