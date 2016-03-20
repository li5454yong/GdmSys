package com.lxg.dao;

import java.util.List;

import com.lxg.entity.User;


/**
 * @author lxg
 *
 * 2016年3月14日下午8:32:27
 */
public interface UserDao {

	public List<User> findEntity(String hql, Object... objects);
	
	public void save(User user);
	
	public void updatePW(int id,String passWd);
	
	public void updateTeacher(int id, int tid, String tname);
	
	public List getSchedule(int id);
	
	public int getStuNum(int tid);
	
	public void updatePic(int id, String path);
}
