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
import com.taller1.CristianLasso.back.DAOs.AutotransitionDao;
import com.taller1.CristianLasso.back.model.Autotransition;

@DirtiesContext
@SpringBootTest
@ContextConfiguration(classes = {PersistenceContext.class, Taller1Application.class})
public class AutotransitionDaoTest {
	
	@Autowired
	public AutotransitionDao autotranDao;
	
	protected Autotransition autotran;
	
	protected void setup() {
		autotran = new Autotransition();
		autotran.setAutotranName("VojabesTest");
		autotran.setAutotranIsactive("Y");
		autotran.setAutotranLogicaloperand("AND");
	}
	
	@Autowired
	public AutotransitionDaoTest(AutotransitionDao autotransitionDao) {
		this.autotranDao = autotransitionDao;
	}
	
	@Test
	protected void test1() {
		assertTrue(true);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void saveTest() {
		setup();
		autotranDao.save(autotran);
		assertNotNull(autotranDao.findById(autotran.getAutotranId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void deleteTest() {
		setup();
		autotranDao.save(autotran);
		assertNotNull(autotranDao.findById(autotran.getAutotranId()));
		autotranDao.delete(autotran);
		assertNull(autotranDao.findById(autotran.getAutotranId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void editTest() {
		setup();
		autotranDao.save(autotran);
		autotran.setAutotranName("Testeo");
		autotranDao.edit(autotran);
		assertEquals("Testeo", autotranDao.findById(autotran.getAutotranId()).getAutotranName());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByIdTest() {
		setup();
		autotranDao.save(autotran);
		assertEquals(5, autotranDao.findById(autotran.getAutotranId()).getAutotranId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByNameTest() {
		setup();
		autotranDao.save(autotran);
		assertNotNull(autotranDao.findByName("VojabesTest"));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByActiveTest() {
		setup();
		autotranDao.save(autotran);
		assertNotNull(autotranDao.findByActive("Y"));
	}
	
}
