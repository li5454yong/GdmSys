package com.lxg.dao;

import java.util.List;

import com.lxg.entity.DailyLog;

public interface DailyLogDao {

	public void save(DailyLog po);
	
	public List<DailyLog> list(int sid);
}
