package com.lxg.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.OpeningReportDao;
import com.lxg.entity.OpeningReport;

@Repository("openingReportDao")
public class OpeningReportDaoImpl implements OpeningReportDao {

	@Resource
	private SessionFactory sf;
	
	public void save(OpeningReport po) {
		
		sf.getCurrentSession().save(po);
	}

	public List<OpeningReport> get(int sid) {
		
		String sql = "from OpeningReport where sid = ?";
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, sid);
		
		return query.list();
		
	}
	
	public List getList(int tid){
		String sql = "select * from openingreport o LEFT JOIN user u on o.sid=u.id where u.tid=?";
		
		return null;
	}

	public void update(int id, String suggestion, int checkstatus) {
		String sql = "update OpeningReport set suggestion=?,checkstatus=?,upd_date=? where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, suggestion);
		query.setParameter(1, checkstatus);
		query.setParameter(2, new Date());
		query.setParameter(3, id);
		
		query.executeUpdate();
	}

}
