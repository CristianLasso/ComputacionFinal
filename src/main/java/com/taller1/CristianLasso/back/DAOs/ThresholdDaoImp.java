package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller1.CristianLasso.back.model.Threshold;

@Repository
@Scope("singleton")
public class ThresholdDaoImp implements ThresholdDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Threshold entity) {
		entityManager.persist(entity);
		
	}

	@Override
	@Transactional
	public void delete(Threshold entity) {
		entityManager.remove(entity);
		
	}

	@Override
	@Transactional
	public void edit(Threshold entity) {
		entityManager.merge(entity);
		
	}

	@Override
	@Transactional
	public Threshold findById(long id) {
		return entityManager.find(Threshold.class, id);
	}

	@Override
	@Transactional
	public List<Threshold> findAll() {
		String consulta= "SELECT a FROM Threshold a";
		return entityManager.createQuery(consulta).getResultList();
	}

	@Override
	@Transactional
	public List<Threshold> findByName(String name) {
		String consulta= "SELECT a FROM Threshold a WHERE a.thresName = :name";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Threshold> findByValue(String thresValue) {
		String consulta= "SELECT a FROM Threshold a WHERE a.thresValue = :thresValue";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("thresValue", thresValue);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Threshold> findByValuetype(String thresValuetype) {
		String consulta= "SELECT a FROM Threshold a WHERE a.thresValuetype = :thresValuetype";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("thresValuetype", thresValuetype);
		return query.getResultList();
	}

}
