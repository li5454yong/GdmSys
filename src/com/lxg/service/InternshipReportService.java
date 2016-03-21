package com.lxg.service;

import java.util.List;

import com.lxg.entity.InternshipReport;

/**
 * 实习报告
 * @author 李新广
 *
 * 2016年3月18日下午3:44:34
 */
public interface InternshipReportService {
	
	public void save(InternshipReport po);
	
	public List<InternshipReport> get(int userId);
}
