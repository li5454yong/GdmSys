package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.UserDao;
import com.lxg.entity.User;
import com.lxg.service.UserService;

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
}
