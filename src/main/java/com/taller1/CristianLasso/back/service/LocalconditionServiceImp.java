package com.taller1.CristianLasso.back.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.DAOs.LocalconditionDao;
import com.taller1.CristianLasso.back.model.Localcondition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.repository.PreconditionRepository;
import com.taller1.CristianLasso.back.repository.ThresholdRepository;

@Service
public class LocalconditionServiceImp implements LocalconditionService{

	private LocalconditionDao localDao;
	private PreconditionRepository preconRepo;
	private ThresholdRepository thresRepo;
	
	@Autowired
	public LocalconditionServiceImp(LocalconditionDao localRepo, PreconditionRepository preconRepo, ThresholdRepository thresRepo) {
		this.localDao = localRepo;
		this.preconRepo = preconRepo;
		this.thresRepo = thresRepo;
	}
	
	@Override
	public Localcondition saveLocalcondition(long loconId, String loconColumnname, String loconKeycolumn,
			String loconOperator, String loconQuerystring, String loconTablename, String loconValuetype,
			long precondition, long threshold) throws RuntimeException {
		// TODO Auto-generated method stub
		if (loconTablename.equalsIgnoreCase("") || loconTablename.split(" ").length > 1) {
			throw new RuntimeException();
		}
		
		if (loconKeycolumn.split(" ").length > 1 || loconColumnname.split(" ").length > 1) {
			throw new RuntimeException();
		}
		
		if (!(loconOperator.equalsIgnoreCase("==") ||
				loconOperator.equalsIgnoreCase("<>") ||
				loconOperator.equalsIgnoreCase("< >"))) {
			throw new RuntimeException();
		}
		
		if (preconRepo.findById(precondition).isEmpty() || thresRepo.findById(threshold).isEmpty()) {
			throw new RuntimeException();
		}
		
		Precondition precon = preconRepo.findById(precondition).get();
		Threshold thres = thresRepo.findById(threshold).get();
		
		Localcondition local = new Localcondition();
		local.setLoconId(loconId);
		local.setLoconColumnname(loconColumnname);
		local.setLoconKeycolumn(loconKeycolumn);
		local.setLoconOperator(loconOperator);
		local.setLoconQuerystring(loconQuerystring);
		local.setLoconTablename(loconTablename);
		local.setLoconValuetype(loconValuetype);
		local.setPrecondition(precon);
		local.setThreshold(thres);
		
		localDao.save(local);
		return local;
	}

	@Override
	public Localcondition editLocalcondition(long loconId, String loconColumnname, String loconKeycolumn,
			String loconOperator, String loconQuerystring, String loconTablename, String loconValuetype,
			long precondition, long threshold) throws RuntimeException {
		// TODO Auto-generated method stub
		if (loconTablename.equalsIgnoreCase("") || loconTablename.split(" ").length > 1) {
			throw new RuntimeException();
		}
		
		if (loconKeycolumn.split(" ").length > 1 || loconColumnname.split(" ").length > 1) {
			throw new RuntimeException();
		}
		
		if (!(loconOperator.equalsIgnoreCase("==") ||
				loconOperator.equalsIgnoreCase("<>") ||
				loconOperator.equalsIgnoreCase("< >"))) {
			throw new RuntimeException();
		}
		
		if (preconRepo.findById(precondition).isEmpty() || thresRepo.findById(threshold).isEmpty()) {
			throw new RuntimeException();
		}
		
		Precondition precon = preconRepo.findById(precondition).get();
		Threshold thres = thresRepo.findById(threshold).get();
		
		Localcondition newLocal = localDao.findById(loconId).get();

		newLocal.setLoconColumnname(loconColumnname);
		newLocal.setLoconKeycolumn(loconKeycolumn);
		newLocal.setLoconOperator(loconOperator);
		newLocal.setLoconQuerystring(loconQuerystring);
		newLocal.setLoconTablename(loconTablename);
		newLocal.setLoconValuetype(loconValuetype);
		newLocal.setPrecondition(precon);
		newLocal.setThreshold(thres);
		
		localDao.delete(newLocal);
		localDao.save(newLocal);
		return newLocal;
	}
	
	@Override
	public Iterable<Localcondition> findAll() {
		return localDao.findAll();
	}

	@Override
	public void save(Localcondition localcondition) {
		localDao.save(localcondition);
	}

	@Override
	public Localcondition findById(long id) {
		return localDao.findById(id);
	}

	@Override
	public void delete(Localcondition localcondition) {
		localDao.delete(localcondition);
	}

}
