package com.lxg.service;

import java.util.List;

import com.lxg.entity.User;


/**
 * @author lxg
 *
 * 2016年3月14日下午8:35:58
 */
public interface UserService {

	public List<User> login(Object... objects);
	
	public void save(User user);
	
	public List<User> getList(Object... objects);
	
	public void updatePW(int id,String pw);
	
	public void updateTeacher(int id,int tid,String tname);
	
	public List getSchedule(int id);
	
	public int getStuNum(int tid);
	
	public void updatePic(int id,String path);
}
