package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.taller1.CristianLasso.back.model.HatParameter;

@Repository
@Scope("singleton")
public class HatParameterDaoImp implements HatParameterDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public HatParameter save(HatParameter HatParameter) {
		// TODO Auto-generated method stub
		entityManager.persist(HatParameter);
		return HatParameter;
	}

	@Override
	public HatParameter update(HatParameter HatParameter) {
		// TODO Auto-generated method stub
		entityManager.merge(HatParameter);
		return HatParameter;
	}

	@Override
	public void delete(HatParameter HatParameter) {
		// TODO Auto-generated method stub
		entityManager.remove(HatParameter);
				
	}

	@Override
	public List<HatParameter> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HatParameter findById(HatParameter id) {
		// TODO Auto-generated method stub
		return null;
	}

}
