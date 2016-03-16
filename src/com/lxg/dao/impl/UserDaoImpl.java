package com.lxg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lxg.dao.UserDao;
import com.lxg.entity.User;

/**
 * @author lxg
 *
 * 2016年3月14日下午8:34:10
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Resource
	private SessionFactory sf;
	
	public List<User> findEntity(String hql, Object... objects) {
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}

	@Override
	public void save(User user) {
		sf.getCurrentSession().save(user);
	}

	/**
	 * 重置密码
	 */
	public void updatePW(int id,String passWd) {
		String sql = "update User set passwd=? where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setString(0, passWd);
		query.setInteger(1, id);
		query.executeUpdate();
		
	}

	public void updateTeacher(int id, int tid, String tname) {
		String sql = "update User set tid=?,tname=? where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setParameter(0, tid);
		query.setParameter(1, tname);
		query.setParameter(2, id);
		
		query.executeUpdate();
	}

}
