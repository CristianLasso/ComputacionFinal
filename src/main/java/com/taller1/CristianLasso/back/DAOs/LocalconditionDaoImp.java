package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller1.CristianLasso.back.model.Localcondition;

@Repository
@Scope("singleton")
public class LocalconditionDaoImp implements LocalconditionDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Localcondition entity) {
		entityManager.persist(entity);
		
	}

	@Override
	@Transactional
	public void delete(Localcondition entity) {
		entityManager.remove(entity);
		
	}

	@Override
	@Transactional
	public void edit(Localcondition entity) {
		entityManager.merge(entity);
		
	}

	@Override
	@Transactional
	public Localcondition findById(long id) {
		return entityManager.find(Localcondition.class, id);
	}

	@Override
	@Transactional
	public List<Localcondition> findAll() {
		String consulta= "SELECT a FROM Localcondition a";
		return entityManager.createQuery(consulta).getResultList();
	}

	@Override
	@Transactional
	public List<Localcondition> findByName(String name) {
		String consulta= "SELECT a FROM Localcondition a WHERE a.loconTablename = :name";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Localcondition> findByValuetype(String loconValuetype) {
		String consulta= "SELECT a FROM Localcondition a WHERE a.loconValuetype = :loconValuetype";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("loconValuetype", loconValuetype);
		return query.getResultList();
	}

}
