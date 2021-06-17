package com.taller1.CristianLasso.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.model.Userr;
import com.taller1.CristianLasso.back.repository.UserrRepository;

@Service
public class UserrServiceImp implements UserrService {

	private UserrRepository usRepo;

	@Autowired
	public UserrServiceImp(UserrRepository usRepo) {
		this.usRepo = usRepo;
	}
	
	@Override
	public void save(Userr us) {
		usRepo.save(us);
	}
}
