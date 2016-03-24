package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.DailyLogDao;
import com.lxg.entity.DailyLog;
import com.lxg.service.DailyLogService;

@Service
public class DailyLogServiceImpl implements DailyLogService {

	@Resource
	private DailyLogDao dao;

	public void save(DailyLog po) {
		
		dao.save(po);
	}

	public List<DailyLog> list(int sid) {
		
		return dao.list(sid);
	}

}
