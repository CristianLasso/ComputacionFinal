package com.taller1.CristianLasso.back.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.DAOs.SymptomquestionDao;
import com.taller1.CristianLasso.back.model.Symptompoll;
import com.taller1.CristianLasso.back.model.Symptomquestion;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;

@Service
public class SymptomquestionServiceImp implements SymptomquestionService{

	
	private SymptomquestionDao symptomquestionDao;
	private FevInstitutionRepository intsRepo;
	
	
	@Autowired
	public SymptomquestionServiceImp( SymptomquestionDao symptomquestionDao, FevInstitutionRepository intsRepo ) {
		// TODO Auto-generated constructor stub
		this.symptomquestionDao = symptomquestionDao;
		this.intsRepo = intsRepo;
	}


	@Override
	public Symptomquestion saveSymptomquestion(long sympquesId, String sympquesActivationanswer, String sympquesIsactive,
			String sympquesName, BigDecimal sympquesWeight) {
		// TODO Auto-generated method stub
		
		Symptomquestion symptomquestion = new Symptomquestion();
		symptomquestion.setSympquesId(sympquesId);
		symptomquestion.setSympquesActivationanswer(sympquesActivationanswer);
		symptomquestion.setSympquesIsactive(sympquesIsactive);
		symptomquestion.setSympquesName(sympquesName);
		symptomquestion.setSympquesWeight(sympquesWeight);
		
		return symptomquestion;
	}


	@Override
	public Symptomquestion editSymptomquestion(long sympquesId, String sympquesActivationanswer, String sympquesIsactive,
			String sympquesName, BigDecimal sympquesWeight) {
		// TODO Auto-generated method stub
		Symptomquestion symptomquestion = symptomquestionDao.findById(sympquesId);
		symptomquestion.setSympquesActivationanswer(sympquesActivationanswer);
		symptomquestion.setSympquesIsactive(sympquesIsactive);
		symptomquestion.setSympquesName(sympquesName);
		symptomquestion.setSympquesWeight(sympquesWeight);
		symptomquestionDao.delete(symptomquestion);
		symptomquestionDao.save(symptomquestion);
		return symptomquestion;
	}
	
	@Override
	public void save(Symptomquestion Symptomquestion) {
		symptomquestionDao.save(Symptomquestion);
	}


	


	@Override
	public void delete(Symptomquestion Symptomquestion) {
		// TODO Auto-generated method stub
		symptomquestionDao.delete(Symptomquestion);
	}


	@Override
	public Iterable<Symptomquestion> findAll() {
		// TODO Auto-generated method stub
		return symptomquestionDao.findAll();
	}


	@Override
	public Symptomquestion findById(long sympollId) {
		// TODO Auto-generated method stub
		return symptomquestionDao.findById(sympollId);
	}


	@Override
	public void update(Symptomquestion Symptomquestion) {
		// TODO Auto-generated method stub
		symptomquestionDao.update(Symptomquestion);
	}



	
	

}
