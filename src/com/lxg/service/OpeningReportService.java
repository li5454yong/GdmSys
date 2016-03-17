package com.lxg.service;

import java.util.List;

import com.lxg.entity.OpeningReport;

/**
 * 
 * @author 李新广
 *
 * 2016年3月17日上午10:53:08
 */
public interface OpeningReportService {

	public void save(OpeningReport po);
	
	public List<OpeningReport> get(int id);
	
	public void update(int id,String suggestion,int checkstatus);
}
