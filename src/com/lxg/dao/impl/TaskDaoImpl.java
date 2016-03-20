package com.lxg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.TaskDao;
import com.lxg.entity.Task;

@Repository("taskDao")
public class TaskDaoImpl implements TaskDao {

	@Resource
	private SessionFactory sf;
	
	public void initTask(Task t) {
		
		sf.getCurrentSession().save(t);

	}

	
	/**
	 * 获取任务列表
	 */
	public List<Task> getTaskList(String sql,Object... objects) {
		
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		
		return query.list();
	}

	/**
	 * 更新任务
	 */
	public void updateTask(String sql,Object... objects) {
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		
		query.executeUpdate();
	}


	@Override
	public Task getTask(String sql, Object... objects) {
		Query query = sf.getCurrentSession().createQuery(sql);
		
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		List<Task> list = query.list();
		return list.get(0);
	}

}
