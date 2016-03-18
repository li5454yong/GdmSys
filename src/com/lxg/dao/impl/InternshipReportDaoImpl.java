package com.lxg.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.InternshipReportDao;
import com.lxg.entity.InternshipReport;

@Repository("internshipReportDao")
public class InternshipReportDaoImpl implements InternshipReportDao {

	@Resource
	private SessionFactory sf;
	
	public void save(InternshipReport po) {
		sf.getCurrentSession().save(po);
	}

	public void update(int status, int id) {
		String sql = "udpate InternshipReport set status=? where id=?";
		
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setParameter(0, status);
		query.setParameter(1, id);
		
		query.executeUpdate();
	}
	

}
