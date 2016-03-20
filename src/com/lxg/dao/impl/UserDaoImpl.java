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

	public List getSchedule(int id) {
		try{
		String sql = "select * from task t LEFT JOIN stu_task s on u.id=t.tid";
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		List list = query.list();
		Object[] objs = (Object[]) list.get(0);
	 	System.out.println(objs[0]);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取某导师带领的学生人数
	 */
	public int getStuNum(int tid) {
		String sql = "select count(*) from User where tid=?";
		Query query = sf.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, tid);
		
		Object[] obj = (Object[]) query.list().get(0);
		
		return Integer.parseInt(obj[0].toString());
	}

	public void updatePic(int id, String path) {
		String sql = "update User set pic=? where id=?";
		Query query = sf.getCurrentSession().createQuery(sql);
		
		query.setString(0, path);
		query.setInteger(1, id);
		query.executeUpdate();
			
	}

}
