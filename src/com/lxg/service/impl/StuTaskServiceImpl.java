package com.lxg.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.StuTaskDao;
import com.lxg.entity.StuTask;
import com.lxg.service.StuTaskService;

/**
 * @author lxg
 *
 * 2016年3月16日下午9:24:21
 */
@Service
public class StuTaskServiceImpl implements StuTaskService {

	@Resource
	private StuTaskDao dao;
	
	public void save(StuTask po) {
		
		dao.save(po);
	}

	/**
	 * 根据导师id获取完成某任务的学生人数
	 */
	public int getCount(int tid,int taskId) {
		return dao.getCount(tid, taskId);
	}

}
