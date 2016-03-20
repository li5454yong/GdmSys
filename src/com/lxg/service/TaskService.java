package com.lxg.service;

import java.util.List;

import com.lxg.entity.Task;

public interface TaskService {

	public void initTask(int tid);
	
	public List<Task> getTaskList(Object... objects);
	
	public Task getTask(Object... objects);
	
	public void updateTask(Object... objects);
	
}
