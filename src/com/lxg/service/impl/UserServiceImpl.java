package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.UserDao;
import com.lxg.entity.User;
import com.lxg.service.UserService;
import com.lxg.utils.MD5;

/**
 * @author lxg
 *
 * 2016年3月14日下午8:36:27
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao dao;

	@Override
	public List<User> login(Object... objects) {
		String hql = "from User where stu_num=?";
		try{
			return dao.findEntity(hql, objects);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(User user) {
		dao.save(user);
	}

	/**
	 * 获取学生列表
	 */
	public List<User> getList(Object... objects) {
		String hql = "from User where power=?";
		try{
			return dao.findEntity(hql, objects);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 重置密码
	 */
	public void updatePW(int id) {
		String passWd = MD5.MD5Encode("111111");
		dao.updatePW(id, passWd);
	}

	public void updateTeacher(int id, int tid, String tname) {
		
		dao.updateTeacher(id, tid, tname);
	}

	/**
	 * 获取当前用户的任务进度
	 */
	public List getSchedule(int id) {
		
		return null;
	}

	/**
	 * 获取某导师带领的学生人数
	 */
	public int getStuNum(int tid) {
		
		return dao.getStuNum(tid);
	}
}
