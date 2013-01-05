package com.faisal.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.faisal.example.domain.Analytics;

@Configuration
public class AnalyticsDaoImpl implements AnalyticsDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void save(List<Analytics> analytics) {
		hibernateTemplate.saveOrUpdateAll(analytics);
	}

	public void update(List<Analytics> analytics) {
		// TODO Auto-generated method stub
		
	}

}
