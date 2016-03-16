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
	
	/**
	 * 初始化任务
	 */
	public void initTask(int tid) {
		
		//List<Task> list = new ArrayList<Task>();
		
		Task t1 = new Task();
		t1.setOrder_num(1);
		t1.setTname("任务书");
		t1.setStatus(0);
		t1.setTid(tid);
		
		dao.initTask(t1);
		
		Task t2 = new Task();
		
		t2.setOrder_num(2);
		t2.setTname("开题报告");
		t2.setStatus(0);
		t2.setTid(tid);
		
		dao.initTask(t2);
		
		Task t3 = new Task();
		
		t3.setOrder_num(3);
		t3.setTname("实习报告");
		t3.setStatus(0);
		t3.setTid(tid);
		
		dao.initTask(t3);
		
		Task t4 = new Task();
		
		t4.setOrder_num(4);
		t4.setTname("毕业设计");
		t4.setStatus(0);
		t4.setTid(tid);
		
		dao.initTask(t4);
		
		Task t5 = new Task();
		
		t5.setOrder_num(5);
		t5.setTname("毕业论文");
		t5.setStatus(0);
		t5.setTid(tid);
		
		dao.initTask(t5);
		
		Task t6 = new Task();
		
		t6.setOrder_num(6);
		t6.setTname("工作日志");
		t6.setStatus(0);
		t6.setTid(tid);
		
		dao.initTask(t6);
		
		Task t7 = new Task();
		
		t7.setOrder_num(7);
		t7.setTname("答辩成绩");
		t7.setStatus(0);
		t7.setTid(tid);
		
		dao.initTask(t7);
		
		
		
	}

	/**
	 * 获取任务列表
	 */
	public List<Task> getTaskList(Object... objects) {
		String sql = "from Task where tid=?";
		
		return dao.getTaskList(sql, objects);
	}

	/**
	 * 更新任务
	 */
	public void updateTask(Object... objects) {
		String sql = "update Task set stime=?,etime=?,status=? where tid=?";
		
		dao.updateTask(sql, objects);
	}

}
