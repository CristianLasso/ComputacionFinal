package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller1.CristianLasso.back.model.Precondition;

@Repository
@Scope("singleton")
public class PreconditionDaoImp implements PreconditionDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Precondition entity) {
		entityManager.persist(entity);
		
	}

	@Override
	@Transactional
	public void delete(Precondition entity) {
		entityManager.remove(entity);
		
	}

	@Override
	@Transactional
	public void edit(Precondition entity) {
		entityManager.merge(entity);
		
	}

	@Override
	@Transactional
	public Precondition findById(long id) {
		return entityManager.find(Precondition.class, id);
	}

	@Override
	@Transactional
	public List<Precondition> findAll() {
		String consulta= "SELECT a FROM Precondition a";
		return entityManager.createQuery(consulta).getResultList();
	}

}
