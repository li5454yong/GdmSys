package com.lxg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.TaskDao;
import com.lxg.entity.Task;
import com.lxg.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Resource
	private TaskDao dao;
	
	public void initTask(int tid) {
		
		List<Task> list = new ArrayList<Task>();
		

	}

}
