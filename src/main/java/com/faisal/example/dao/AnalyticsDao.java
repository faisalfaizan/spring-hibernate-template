package com.faisal.example.dao;

import java.util.List;

import com.faisal.example.domain.Analytics;

public interface AnalyticsDao {

	void save(List<Analytics> analytics);
	void update(List<Analytics> analytics);
}
