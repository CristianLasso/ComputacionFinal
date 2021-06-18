package com.taller1.CristianLasso.back.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.DAOs.PreconditionDao;
import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.repository.AutotransitionRepository;

@Service
public class PreconditionServiceImp implements PreconditionService{
	
	private PreconditionDao preconDao;
	private AutotransitionRepository autotranRepo;
	
	@Autowired
	public PreconditionServiceImp(PreconditionDao preconRepo, AutotransitionRepository autotranRepo) {
		this.preconDao = preconRepo;
		this.autotranRepo = autotranRepo;
	}
	
	@Override
	public Precondition savePrecondition(long preconId, String preconLogicaloperand, long autotranId) throws RuntimeException {
		// TODO Auto-generated method stub		
		if (!(preconLogicaloperand.equalsIgnoreCase("OR") || preconLogicaloperand.equalsIgnoreCase("AND"))) {
			throw new RuntimeException();
		}
		
		if (autotranRepo.findById(autotranId).isEmpty()) {
			throw new RuntimeException();
		}
		
		Autotransition auto = autotranRepo.findById(autotranId).get();
		
		Precondition precon = new Precondition();
		precon.setPreconId(preconId);
		precon.setPreconLogicaloperand(preconLogicaloperand);
		precon.setAutotransition(auto);
		
		preconDao.save(precon);
		return precon;
	}

	@Override
	public Precondition editPrecondition(long preconId, String preconLogicaloperand, long autotranId) throws RuntimeException {
		// TODO Auto-generated method stub
		if (!(preconLogicaloperand.equalsIgnoreCase("OR") || preconLogicaloperand.equalsIgnoreCase("AND"))) {
			throw new RuntimeException();
		}
		
		if (autotranRepo.findById(autotranId).isEmpty()) {
			throw new RuntimeException();
		}
		
		Autotransition auto = autotranRepo.findById(autotranId).get();
		
		Precondition newPrecon = preconDao.findById(preconId).get();
		newPrecon.setPreconLogicaloperand(preconLogicaloperand);
		newPrecon.setAutotransition(auto);
		
		preconDao.delete(newPrecon);
		preconDao.save(newPrecon);
		return newPrecon;
	}
	
	@Override
	public Iterable<Precondition> findAll() {
		return preconDao.findAll();
	}

	@Override
	public void save(Precondition precondition) {
		preconDao.save(precondition);
	}
	
	@Override
	public void edit(Precondition precondition) {
		preconDao.edit(precondition);
	}

	@Override
	public Precondition findById(long id) {
		return preconDao.findById(id);
	}

	@Override
	public void delete(Precondition precondition) {
		preconDao.delete(precondition);
	}
	
}
