package com.lxg.service;

import com.lxg.entity.StuTask;

/**
 * @author lxg
 *
 * 2016年3月16日下午9:22:19
 */
public interface StuTaskService {

	public void save(StuTask po);
	
	public int getCount(int tid,int taskId);
}
