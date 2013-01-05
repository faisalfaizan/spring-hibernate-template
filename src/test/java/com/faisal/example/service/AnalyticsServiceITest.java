package com.faisal.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.example.domain.Analytics;

@ContextConfiguration(locations = {"classpath:/com/faisal/example/spring-feeds-context.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class AnalyticsServiceITest {

	@Autowired
	private AnalyticsService analyticsService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Transactional
	@Test
	public void saveListOfOneAnalytics() {
		Analytics analytics = new Analytics();
		analytics.setName("Vodafone");
		analytics.setBloomberg("VOD LN");
		
		List<Analytics> analyticsList = new ArrayList<Analytics>();
		analyticsList.add(analytics);
		
		Session session = sessionFactory.getCurrentSession();
		Analytics analytics1 = (Analytics) session.get(Analytics.class, 1L);
		assertNull(analytics1);
		
		analyticsService.saveAnalytics(analyticsList);
		
		Analytics analytics2 = (Analytics) session.get(Analytics.class, 1L);
		assertNotNull(analytics2);
		assertEquals(analytics.getName(), analytics2.getName());
	}
	
	@Transactional
	@Test
	public void saveListOfAnalytics() {
		Analytics analytics = new Analytics();
		analytics.setName("Vodafone");
		analytics.setBloomberg("VOD LN");
		
		Analytics analytics0 = new Analytics();
		analytics.setName("SAIL");
		analytics.setBloomberg("SAIL IN");
		
		Analytics analytics00 = new Analytics();
		analytics.setName("Google");
		analytics.setBloomberg("GOO NS");
		
		List<Analytics> analyticsList = new ArrayList<Analytics>();
		analyticsList.add(analytics);
		analyticsList.add(analytics0);
		analyticsList.add(analytics00);
		
		Session session = sessionFactory.getCurrentSession();
		int initialCount = (int) session.createQuery("from Analytics").list().size();
		assertSame(0, initialCount);
		
		analyticsService.saveAnalytics(analyticsList);
		
		int savedCount = (int) session.createQuery("from Analytics").list().size();
		assertSame(3, savedCount);
		
		Analytics analytics3 = (Analytics) session.get(Analytics.class, 3L);
		assertNotNull(analytics3);
		assertEquals(analytics00.getName(), analytics3.getName());
	}

	@Test
	@Ignore
	public void testUpdateAnalytics() {
		fail("Not yet implemented");
	}

}
