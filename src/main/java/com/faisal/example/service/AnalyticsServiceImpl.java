package com.faisal.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.faisal.example.dao.AnalyticsDao;
import com.faisal.example.domain.Analytics;

@Configuration
public class AnalyticsServiceImpl implements AnalyticsService{
	
	@Autowired
	private AnalyticsDao analyticsDao;

	public void saveAnalytics(List<Analytics> analytics) {
		if(analyticsDao == null && analyticsDao.equals(""))
			System.out.println("What a bug");
		
		analyticsDao.save(analytics);
	}

	public void updateAnalytics(List<Analytics> analytics) {
		// TODO Auto-generated method stub
		
	}

}
