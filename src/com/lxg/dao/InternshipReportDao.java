package com.lxg.dao;

import java.util.List;

import com.lxg.entity.InternshipReport;

public interface InternshipReportDao {

	public void save(InternshipReport po);
	
	public void update(int status,int id);
	
	public List<InternshipReport> get(int userId);
	
}
