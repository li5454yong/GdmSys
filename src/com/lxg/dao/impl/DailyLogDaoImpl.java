package com.lxg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.DailyLogDao;
import com.lxg.entity.DailyLog;

@Repository("dailyLogDao")
public class DailyLogDaoImpl implements DailyLogDao {

	@Resource
	private SessionFactory sf;
	
	public void save(DailyLog po) {
		
		sf.getCurrentSession().save(po);

	}

	public List<DailyLog> list(int sid) {
		
		String sql = "from DailyLog where sid=? order by init_date desc"; 
		
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, sid);
		
		return query.list();
	}

}
