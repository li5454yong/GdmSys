package com.lxg.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.TaskDao;

@Repository("taskDao")
public class TaskDaoImpl implements TaskDao {

	@Resource
	private SessionFactory sf;
	
	public void initTask() {
		

	}

}
