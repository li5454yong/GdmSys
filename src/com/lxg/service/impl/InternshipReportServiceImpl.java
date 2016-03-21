package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.InternshipReportDao;
import com.lxg.entity.InternshipReport;
import com.lxg.service.InternshipReportService;

@Service
public class InternshipReportServiceImpl implements InternshipReportService {

	@Resource
	private InternshipReportDao dao;
	
	public void save(InternshipReport po) {
		dao.save(po);
	}

	public List<InternshipReport> get(int userId) {
		
		return dao.get(userId);
	}

}
