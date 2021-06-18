package com.taller1.CristianLasso.back.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.DAOs.AutotransitionDao;
import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.Eventstatus;
import com.taller1.CristianLasso.back.repository.EventstatusRepository;
import com.taller1.CristianLasso.back.repository.FevInstitutionRepository;

@Service
public class AutotransitionServiceImp implements AutotransitionService{

	private AutotransitionDao autotranDao;
	private FevInstitutionRepository instRepo;
	private EventstatusRepository eventRepo;
	
	@Autowired
	public AutotransitionServiceImp(AutotransitionDao autotranRepo, FevInstitutionRepository instRepo, EventstatusRepository eventRepo) {
		this.autotranDao = autotranRepo;
		this.instRepo = instRepo;
		this.eventRepo = eventRepo;
	}
	
	@Override
	public Autotransition saveAutotransition(long autotranId, String autotranIsactive, String autotranLogicaloperand,
			String autotranName, long instId, long event1Id, long event2Id) throws RuntimeException {
		if (autotranName.equalsIgnoreCase("")) {
			throw new RuntimeException();
		}
		
		if (!(autotranIsactive.equalsIgnoreCase("Y") || autotranIsactive.equalsIgnoreCase("N"))) {
			throw new RuntimeException();
		}
		
		if (!(autotranLogicaloperand.equalsIgnoreCase("OR") || autotranLogicaloperand.equalsIgnoreCase("AND"))) {
			throw new RuntimeException();
		}
		
		if (instRepo.findById(instId).isEmpty()) {
			throw new RuntimeException();
		}
		
		if (eventRepo.findById(event1Id).isEmpty() || eventRepo.findById(event2Id).isEmpty()) {
			throw new RuntimeException();
		}
		
		Eventstatus event1 = eventRepo.findById(event1Id).get();
		Eventstatus event2 = eventRepo.findById(event2Id).get();
		
		Autotransition auto = new Autotransition();
		auto.setAutotranId(autotranId);
		auto.setAutotranIsactive(autotranIsactive);
		auto.setAutotranLogicaloperand(autotranLogicaloperand);
		auto.setAutotranName(autotranName);
		auto.setInstInstId(instId);
		auto.setEventstatus1(event1);
		auto.setEventstatus2(event2);
		
		autotranDao.save(auto);
		return auto;
	}

	@Override
	public Autotransition editAutotransition(long autotranId, String autotranIsactive, String autotranLogicaloperand, 
			String autotranName, long instId, long event1Id, long event2Id) throws RuntimeException {
		if (autotranName.equalsIgnoreCase("")) {
			throw new RuntimeException();
		}
		
		if (!(autotranIsactive.equalsIgnoreCase("Y") || autotranIsactive.equalsIgnoreCase("N"))) {
			throw new RuntimeException();
		}
		
		if (!(autotranLogicaloperand.equalsIgnoreCase("OR") || autotranLogicaloperand.equalsIgnoreCase("AND"))) {
			throw new RuntimeException();
		}
		
		if (instRepo.findById(instId).isEmpty()) {
			throw new RuntimeException();
		}
		
		if (eventRepo.findById(event1Id).isEmpty() || eventRepo.findById(event2Id).isEmpty()) {
			throw new RuntimeException();
		}
		
		
		Eventstatus event1 = eventRepo.findById(event1Id).get();
		Eventstatus event2 = eventRepo.findById(event2Id).get();
		
		Autotransition newAuto = autotranDao.findById(autotranId).get();

		newAuto.setAutotranIsactive(autotranIsactive);
		newAuto.setAutotranLogicaloperand(autotranLogicaloperand);
		newAuto.setAutotranName(autotranName);
		newAuto.setInstInstId(instId);
		newAuto.setEventstatus1(event1);
		newAuto.setEventstatus2(event2);
		
		autotranDao.delete(newAuto);
		autotranDao.save(newAuto);
		return newAuto;
	}
	
	@Override
	public Iterable<Autotransition> findAll() {
		return autotranDao.findAll();
	}

	@Override
	public void save(Autotransition autotransition) {
		autotranDao.save(autotransition);
	}
	
	@Override
	public void edit(Autotransition autotransition) {
		autotranDao.edit(autotransition);
	}

	@Override
	public Autotransition findById(long id) {
		return autotranDao.findById(id);
	}

	@Override
	public void delete(Autotransition autotransition) {
		autotranDao.delete(autotransition);
	}
	
}
