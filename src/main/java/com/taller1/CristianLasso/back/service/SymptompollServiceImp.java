package com.taller1.CristianLasso.back.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.DAOs.SymptompollDao;
import com.taller1.CristianLasso.back.model.Symptom;
import com.taller1.CristianLasso.back.model.Symptompoll;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;

@Service
public class SymptompollServiceImp implements SymptompollService{
	
	private SymptompollDao symptompollDao;
	private FevInstitutionRepository instRepo;
	
	
	@Autowired
	public SymptompollServiceImp(SymptompollDao symptompollDao,FevInstitutionRepository instRepo) {
		// TODO Auto-generated constructor stub
		this.symptompollDao = symptompollDao;
		this.instRepo = instRepo;
	}
	
	@Override
	public Symptompoll saveSymptompoll(long sympollId, BigDecimal instInstId, Date sympollEnddate, String sympollName,
			Date sympollStartdate) {
		// TODO Auto-generated method stub
		
		Symptompoll symptompoll = new Symptompoll();
		symptompoll.setSympollId(sympollId);
		symptompoll.setInstInstId(instInstId);
		symptompoll.setSympollEnddate(sympollEnddate);
		symptompoll.setSympollName(sympollName);
		symptompoll.setSympollStartdate(sympollStartdate);
		
		symptompollDao.save(symptompoll);
		
		return symptompoll;
		
	}

	@Override
	public Symptompoll editSymptompoll(long sympollId, BigDecimal instInstId, Date sympollEnddate, String sympollName,
			Date sympollStartdate) {
		// TODO Auto-generated method stub
		
		Symptompoll symptompoll = symptompollDao.findById(sympollId);
		
		symptompoll.setInstInstId(instInstId);
		symptompoll.setSympollEnddate(sympollEnddate);
		symptompoll.setSympollName(sympollName);
		symptompoll.setSympollStartdate(sympollStartdate);
		
		symptompollDao.delete(symptompoll);
		symptompollDao.save(symptompoll);
		
		return symptompoll;
	}

	@Override
	public Iterable<Symptompoll> findAll() {
		// TODO Auto-generated method stub
		
		return symptompollDao.findAll();
	}

	@Override
	public void save(Symptompoll symptompoll) {
		// TODO Auto-generated method stub
		symptompollDao.save(symptompoll);
	}
	
	@Override
	public void update(Symptompoll symptom) {
		symptompollDao.update(symptom);
	}

	@Override
	public void delete(Symptompoll symptompoll) {
		// TODO Auto-generated method stub
		symptompollDao.delete(symptompoll);
	}

	@Override
	public Symptompoll findById(long id) {
		// TODO Auto-generated method stub
		return symptompollDao.findById(id);
	}
	

}
