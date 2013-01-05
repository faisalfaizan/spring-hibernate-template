package com.faisal.example.dao;

import java.util.List;

import com.faisal.example.domain.Analytics;

public interface AnalyticsDao {

	public void save(List<Analytics> analytics);
	public void update(List<Analytics> analytics);
}
