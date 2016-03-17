package com.lxg.dao;

import java.util.List;

import com.lxg.entity.OpeningReport;

public interface OpeningReportDao {

	public void save(OpeningReport po);
	
	public List<OpeningReport> get(int id);
	
	public void update(int id,String suggestion,int checkstatus);
}
