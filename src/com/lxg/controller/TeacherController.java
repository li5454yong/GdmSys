package com.lxg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.lxg.entity.User;

/**
 * 导师controller
 * @author 李新广
 *
 * 2016年3月15日下午5:03:45
 */
public class TeacherController extends BasicController{

	@RequestMapping("initTask")
	public void initTask(HttpServletRequest request){
		User user = getAuthUser();
		
	}
}
