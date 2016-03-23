package com.lxg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.ThesisDao;
import com.lxg.entity.Thesis;

@Repository("thesisDao")
public class ThesisDaoImpl implements ThesisDao {

	@Resource
	private SessionFactory sf;
	
	@Override
	public List<Thesis> getList(int sid) {
		
		String sql = "from Thesis where sid=?";
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setInteger(0, sid);
		
		return query.list();
	}

	@Override
	public void save(Thesis po) {
		sf.getCurrentSession().save(po);
	}

	@Override
	public void update(int status, int id) {
		String sql = "update Thesis set status=? where id=?";
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setInteger(0, status);
		query.setInteger(1, id);
		
		query.executeUpdate();
	}

}
