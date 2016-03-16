package com.lxg.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.StuTaskDao;
import com.lxg.entity.StuTask;

/**
 * @author lxg
 *
 * 2016年3月16日下午9:25:25
 */
@Repository("stuTaskDao")
public class StuTaskDaoImpl implements StuTaskDao {

	@Resource
	private SessionFactory sf;
	
	public void save(StuTask po) {
		
		sf.getCurrentSession().save(po);
	}

	/**
	 * 根据导师id获取完成某任务的学生人数
	 */
	public int getCount(int tid ,int taskId) {
		String sql = "select count(*) from StuTask where tid=? and taskid=?";
		
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, tid);
		query.setParameter(1, taskId);
		
		Object[] obj = (Object[]) query.list().get(0);
		
		return Integer.parseInt(obj[0].toString());
	}

	
	
}
