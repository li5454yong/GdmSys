package com.lxg.service;

import java.util.List;

import com.lxg.entity.DailyLog;

public interface DailyLogService {

	public void save(DailyLog po);
	
	public List<DailyLog> list(int sid);
}
