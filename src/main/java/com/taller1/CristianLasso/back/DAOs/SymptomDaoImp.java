package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller1.CristianLasso.back.model.Symptom;

@Repository
@Scope("singleton")
public class SymptomDaoImp implements SymptomDao {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Symptom save(Symptom Symptom) {
		// TODO Auto-generated method stub
		entityManager.persist(Symptom);
		return Symptom;
	}

	@Override
	@Transactional
	public Symptom update(Symptom Symptom) {
		// TODO Auto-generated method stub
		entityManager.merge(Symptom);
		return Symptom;
	}

	@Override
	@Transactional
	public void delete(Symptom Symptom) {
		// TODO Auto-generated method stub
		entityManager.remove(Symptom);
	}

	@Override
	@Transactional
	public List<Symptom> findAll() {
		// TODO Auto-generated method stub
		String consulta= "SELECT a FROM Autotransition a";
		return entityManager.createQuery(consulta).getResultList();
	}

	@Override
	@Transactional
	public Symptom findById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Symptom.class, id);
	}

}
