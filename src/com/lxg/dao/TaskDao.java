package com.lxg.dao;

import java.util.List;

import com.lxg.entity.Task;

public interface TaskDao {
	
	public void initTask(Task t);
	
	public List<Task> getTaskList(String sql,Object... objects);
	
	public void updateTask(String sql,Object... objects);
	
	public Task getTask(String sql,Object... objects);
}
