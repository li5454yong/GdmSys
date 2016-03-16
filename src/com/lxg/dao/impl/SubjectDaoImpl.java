package com.lxg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.SubjectDao;
import com.lxg.entity.Subject;

@Repository("subjectDao")
public class SubjectDaoImpl implements SubjectDao {

	@Resource
	private SessionFactory sf;
	
	/**
	 * 根据导师id获取课题列表
	 */
	public List<Subject> getList(int tid) {
		String sql = "from Subject where tid=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, tid);
		
		return query.list();
	}

	public void save(Subject s) {
		
		sf.getCurrentSession().save(s);
	}

	/**
	 * 更新课题
	 */
	public void update(String sql, Object... objects) {
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		
		query.executeUpdate();
		
	}

	public List<Subject> getList() {
		String sql = "from Subject";
		Query query = sf.getCurrentSession().createQuery(sql);
		
		return query.list();
	}

}
