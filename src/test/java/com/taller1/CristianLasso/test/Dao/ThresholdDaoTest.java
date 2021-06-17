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
import com.taller1.CristianLasso.back.DAOs.ThresholdDao;
import com.taller1.CristianLasso.back.model.Threshold;

@DirtiesContext
@SpringBootTest
@ContextConfiguration(classes = {PersistenceContext.class, Taller1Application.class})
public class ThresholdDaoTest {
	
	@Autowired
	public ThresholdDao thresDao;
	
	protected Threshold threshold;
	
	protected void setup() {
		threshold = new Threshold();
		threshold.setThresName("VojabesTest");
		threshold.setThresValue("Value");
		threshold.setThresValuetype("String");
	}
	
	@Autowired
	public ThresholdDaoTest(ThresholdDao autotransitionDao) {
		this.thresDao = autotransitionDao;
	}
	
	@Test
	protected void test1() {
		assertTrue(true);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void saveTest() {
		setup();
		thresDao.save(threshold);
		assertNotNull(thresDao.findById(threshold.getThresId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void deleteTest() {
		setup();
		thresDao.save(threshold);
		assertNotNull(thresDao.findById(threshold.getThresId()));
		thresDao.delete(threshold);
		assertNull(thresDao.findById(threshold.getThresId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void editTest() {
		setup();
		thresDao.save(threshold);
		threshold.setThresName("Testeo");
		thresDao.edit(threshold);
		assertEquals("Testeo", thresDao.findById(threshold.getThresId()).getThresName());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByIdTest() {
		setup();
		thresDao.save(threshold);
		assertEquals(5, thresDao.findById(threshold.getThresId()).getThresId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByNameTest() {
		setup();
		thresDao.save(threshold);
		assertNotNull(thresDao.findByName("VojabesTest"));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByValueTest() {
		setup();
		thresDao.save(threshold);
		assertNotNull(thresDao.findByValue("Value"));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByValuetypeTest() {
		setup();
		thresDao.save(threshold);
		assertNotNull(thresDao.findByValuetype("String"));
	}
	
}
