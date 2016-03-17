package com.lxg.service;

import com.lxg.entity.TaskBook;

/**
 * 任务书
 * @author 李新广
 *
 * 2016年3月17日下午1:44:36
 */
public interface TaskBookService {
	
	public void save(TaskBook po);
	
	public void update(int id ,int status);
	
	public TaskBook get(int sid);
	

}
