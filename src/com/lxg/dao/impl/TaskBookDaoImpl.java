package com.lxg.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.TaskBookDao;
import com.lxg.entity.TaskBook;

@Repository("taskBookDao")
public class TaskBookDaoImpl implements TaskBookDao {

	@Resource
	private SessionFactory sf;
	
	public void save(TaskBook po) {
		
		sf.getCurrentSession().save(po);
	}

	public void update(int id, int status) {
		String sql = "update TaskBook set status=? where id=?";
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, status);
		query.setParameter(1, id);
		
		query.executeUpdate();
	}

}
