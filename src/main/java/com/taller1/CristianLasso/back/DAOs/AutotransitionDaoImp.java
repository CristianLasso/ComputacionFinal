package com.taller1.CristianLasso.back.DAOs;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller1.CristianLasso.back.model.Autotransition;

@Repository
@Scope("singleton")
public class AutotransitionDaoImp implements AutotransitionDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Autotransition entity) {
		entityManager.persist(entity);
	}
	
	@Override
	@Transactional
	public void delete(Autotransition entity) {
		entityManager.remove(entity);
	}
	
	@Override
	@Transactional
	public void edit(Autotransition entity) {
		entityManager.merge(entity);
	}
	
	@Override
	@Transactional
	public Autotransition findById(long id) {
		return entityManager.find(Autotransition.class, id);
	}
	
	@Override
	@Transactional
	public List<Autotransition> findAll() {
		String consulta= "SELECT a FROM Autotransition a";
		return entityManager.createQuery(consulta).getResultList();
	}
	
	@Override
	@Transactional
	public List<Autotransition> findByName(String name) {
		String consulta= "SELECT a FROM Autotransition a WHERE a.autotranName = :name";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public List<Autotransition> findByInstId(long instInstId) {
		String consulta= "SELECT a FROM Autotransition a WHERE a.instInstId = :instInstId";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("instInstId", instInstId);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public List<Autotransition> findByActive(String isActive) {
		String consulta= "SELECT a FROM Autotransition a WHERE a.autotranIsactive = :isActive";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("isActive", isActive);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public List<Autotransition> findByAnd() {
		String operand = "AND";
		String consulta= "SELECT a FROM Autotransition a WHERE a.autotranLogicaloperand = :operand";
		Query query = entityManager.createQuery(consulta);
		query.setParameter("operand", "AND");
		return query.getResultList();
	}

}