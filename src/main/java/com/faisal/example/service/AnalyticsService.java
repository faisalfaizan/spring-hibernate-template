package com.faisal.example.service;

import java.util.List;

import com.faisal.example.domain.Analytics;

public interface AnalyticsService {

	public void saveAnalytics(List<Analytics> analytics);
	public void updateAnalytics(List<Analytics> analytics);
}
