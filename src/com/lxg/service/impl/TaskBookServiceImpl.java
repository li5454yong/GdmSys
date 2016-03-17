package com.lxg.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.TaskBookDao;
import com.lxg.entity.TaskBook;
import com.lxg.service.TaskBookService;

@Service
public class TaskBookServiceImpl implements TaskBookService {

	@Resource
	private TaskBookDao dao;
	
	public void save(TaskBook po) {
		dao.save(po);
	}

	public void update(int id,int status) {
		dao.update(id, status);
	}

}
