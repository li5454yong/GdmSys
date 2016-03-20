package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.SubjectDao;
import com.lxg.entity.Subject;
import com.lxg.service.SubjectService;
/**
 * 课题service
 * @author 李新广
 *
 * 2016年3月16日下午12:35:32
 */
@Service
public class SubjectServiceImpl implements SubjectService {

	@Resource
	private SubjectDao dao;
	
	/**
	 * 根据导师id获取课题列表
	 */
	public List<Subject> getList(int tid) {
		
		return dao.getList(tid);
	}

	/**
	 * 新增课题
	 */
	public void save(Subject s) {
		
		dao.save(s);
	}

	/**
	 * 更新课题
	 */
	public void update(Object... objects) {
		String sql = "update Subject set sid=?,sname=?,status=1,num=num-1 where id=?";
		dao.update(sql, objects);
		
	}

	/**
	 * 获取全部课题列表
	 */
	public List<Subject> getList() {
		
		return dao.getList();
	}

	/**
	 * 获取单个课题
	 */
	public Subject get(int id) {
		return dao.get(id);
	}

	/**
	 * 修改
	 */
	public void update(Subject subject) {
		dao.update(subject);
		
	}

	public Subject getByStu(int sid) {
		return dao.getByStu(sid);
	}

}
