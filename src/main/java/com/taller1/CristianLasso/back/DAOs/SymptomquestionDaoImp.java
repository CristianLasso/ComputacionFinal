package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller1.CristianLasso.back.model.Symptompoll;
import com.taller1.CristianLasso.back.model.Symptomquestion;


@Repository
@Scope("singleton")
public class SymptomquestionDaoImp implements SymptomquestionDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Symptomquestion save(Symptomquestion Symptomquestion) {
		// TODO Auto-generated method stub
		entityManager.persist(Symptomquestion);
		return Symptomquestion;
	}

	@Override
	@Transactional
	public Symptomquestion update(Symptomquestion Symptomquestion) {
		// TODO Auto-generated method stub
		entityManager.merge(Symptomquestion);
		return Symptomquestion;
	}

	@Override
	@Transactional
	public void delete(Symptomquestion Symptomquestion) {
		// TODO Auto-generated method stub
		entityManager.remove(Symptomquestion);
		
	}

	@Override
	@Transactional
	public List<Symptomquestion> findAll() {
		String jpql = "SELECT s FROM Symptomquestion s";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	@Transactional
	public Symptomquestion findById(long id) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Symptomquestion.class, id);
	}

}
