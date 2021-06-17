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
import com.taller1.CristianLasso.back.DAOs.LocalconditionDao;
import com.taller1.CristianLasso.back.model.Localcondition;

@DirtiesContext
@SpringBootTest
@ContextConfiguration(classes = {PersistenceContext.class, Taller1Application.class})
public class LocalconditionDaoTest {
	
	@Autowired
	public LocalconditionDao localDao;
	
	protected Localcondition localcon;
	
	protected void setup() {
		localcon = new Localcondition();
		localcon.setLoconTablename("VojabesTest");
		localcon.setLoconValuetype("Value");
	}
	
	@Autowired
	public LocalconditionDaoTest(LocalconditionDao autotransitionDao) {
		this.localDao = autotransitionDao;
	}
	
	@Test
	protected void test1() {
		assertTrue(true);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void saveTest() {
		setup();
		localDao.save(localcon);
		assertNotNull(localDao.findById(localcon.getLoconId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void deleteTest() {
		setup();
		localDao.save(localcon);
		assertNotNull(localDao.findById(localcon.getLoconId()));
		localDao.delete(localcon);
		assertNull(localDao.findById(localcon.getLoconId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void editTest() {
		setup();
		localDao.save(localcon);
		localcon.setLoconTablename("Testeo");
		localDao.edit(localcon);
		assertEquals("Testeo", localDao.findById(localcon.getLoconId()).getLoconTablename());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByIdTest() {
		setup();
		localDao.save(localcon);
		assertEquals(5, localDao.findById(localcon.getLoconId()).getLoconId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByNameTest() {
		setup();
		localDao.save(localcon);
		assertNotNull(localDao.findByName("VojabesTest"));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByValuetypeTest() {
		setup();
		localDao.save(localcon);
		assertNotNull(localDao.findByValuetype("String"));
	}
	
}
