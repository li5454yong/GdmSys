package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.OpeningReportDao;
import com.lxg.entity.OpeningReport;
import com.lxg.service.OpeningReportService;

@Service
public class OpeningReportServiceImpl implements OpeningReportService {

	@Resource
	private OpeningReportDao dao;
	
	public void save(OpeningReport po) {
		
		dao.save(po);

	}

	/**
	 * 根据id获取开题报告
	 */
	public List<OpeningReport> get(int id) {
		
		return dao.get(id);
	}

	/**
	 * 更新开题报告审核状态
	 */
	public void update(int id,String suggestion,int checkstatus) {
		
		dao.update(id, suggestion, checkstatus);
	}

}
