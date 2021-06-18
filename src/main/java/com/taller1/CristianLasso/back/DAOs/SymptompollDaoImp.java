package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller1.CristianLasso.back.model.Symptompoll;

@Repository
@Scope("singleton")
public class SymptompollDaoImp implements SymptompollDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Symptompoll save(Symptompoll Symptompoll) {
		// TODO Auto-generated method stub
		entityManager.persist(Symptompoll);
		return Symptompoll;
	}

	@Override
	public Symptompoll update(Symptompoll Symptompoll) {
		// TODO Auto-generated method stub
		entityManager.merge(Symptompoll);
		return Symptompoll;
	}

	@Override
	public void delete(Symptompoll Symptompoll) {
		// TODO Auto-generated method stub
		entityManager.remove(Symptompoll);
	}

	@Override
	public List<Symptompoll> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symptompoll findById(long sympollId) {
		// TODO Auto-generated method stub
		return entityManager.find(Symptompoll.class, sympollId);
	}
	


}
