package com.lxg.dao;

import com.lxg.entity.StuTask;

/**
 * @author lxg
 *
 * 2016年3月16日下午9:24:50
 */
public interface StuTaskDao {

	public void save(StuTask po);
	
	public int getCount(int tid,int taskId);
}
