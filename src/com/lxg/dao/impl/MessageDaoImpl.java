package com.lxg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.MessageDao;
import com.lxg.entity.Message;

/**
 * @author lxg
 *
 * 2016年3月16日下午9:59:30
 */
@Repository("messageDao")
public class MessageDaoImpl implements MessageDao {

	@Resource
	private SessionFactory sf;
	
	public void save(Message po) {
		
		sf.getCurrentSession().save(po);
	}

	
	public List<Message> getList(int tid) {
		String sql = "from Message where tid=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setInteger(0, tid);
		
		return query.list();
	}

}
