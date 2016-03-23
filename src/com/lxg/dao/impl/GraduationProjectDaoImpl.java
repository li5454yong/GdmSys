package com.lxg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.GraduationProjectDao;
import com.lxg.entity.GraduationProject;

@Repository("graduationProjectDao")
public class GraduationProjectDaoImpl implements GraduationProjectDao{

	@Resource
	private SessionFactory sf;
	
	public void save(GraduationProject po) {
		
		sf.getCurrentSession().save(po);
	}

	
	public List<GraduationProject> get(int sid){
		String sql = "from GraduationProject where sid=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, sid);
		
		return query.list();
	}


	@Override
	public void update(int status, int id) {
		
		String sql = "update GraduationProject set status=? where id=?";
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, status);
		query.setParameter(1, id);
		
		query.executeUpdate();
	}
}
