package com.faisal.example.service;

import java.util.List;

import com.faisal.example.domain.Analytics;

public interface AnalyticsService {

	void saveAnalytics(List<Analytics> analytics);
	void updateAnalytics(List<Analytics> analytics);
}
