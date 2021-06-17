package com.taller1.CristianLasso.test.Dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.taller1.CristianLasso.Taller1Application;
import com.taller1.CristianLasso.back.DAOs.PreconditionDao;
import com.taller1.CristianLasso.back.model.Precondition;

@DirtiesContext
@SpringBootTest
@ContextConfiguration(classes = {PersistenceContext.class, Taller1Application.class})
public class PreconditionDaoTest {
	
	@Autowired
	public PreconditionDao preconDao;
	
	protected Precondition precon;
	
	protected void setup() {
		precon = new Precondition();
	}
	
	@Autowired
	public PreconditionDaoTest(PreconditionDao autotransitionDao) {
		this.preconDao = autotransitionDao;
	}
	
	@Test
	protected void test1() {
		assertTrue(true);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void saveTest() {
		setup();
		preconDao.save(precon);
		assertNotNull(preconDao.findById(precon.getPreconId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void deleteTest() {
		setup();
		preconDao.save(precon);
		assertNotNull(preconDao.findById(precon.getPreconId()));
		preconDao.delete(precon);
		assertNull(preconDao.findById(precon.getPreconId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void editTest() {
		setup();
		preconDao.save(precon);
		precon.setPreconLogicaloperand("OR");
		preconDao.edit(precon);
		assertEquals("OR", preconDao.findById(precon.getPreconId()).getPreconLogicaloperand());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByIdTest() {
		setup();
		preconDao.save(precon);
		assertEquals(5, preconDao.findById(precon.getPreconId()).getPreconId());
	}
	
}
