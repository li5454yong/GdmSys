package com.lxg.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxg.entity.User;
import com.lxg.service.UserService;
import com.lxg.utils.MD5;

/**
 * 
 * @author lxg
 *
 * 2016年3月14日下午8:14:59
 */

@Controller
public class UserController extends BasicController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping("login")
	public void login(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = MD5.MD5Encode(request.getParameter("password"));
		int power = Integer.parseInt(request.getParameter("power"));
		
		List<User> l = userService.login(username);
		if(l.size() == 1){
			User u = l.get(0);
			if(u.getPasswd().equals(password)){
				if(u.getPower() == power){
					request.getSession().setAttribute("USER",u);
					response.getWriter().print("0");//登录成功
				}else{
					response.getWriter().print("3");//身份错误
				}
				
			}else{
				response.getWriter().print("2");//密码错误
			}
		}else{
			response.getWriter().print("1");//用户名不存在
		}
	}
	
	@RequestMapping("toIndex")
	public String toIndex(){
		return "index";
	}
	
	//跳转到登录页面
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}
	
	/**
	 * 获取当前用户的进度
	 */
	@RequestMapping("getSchedule")
	public void getSchedule(){
		
	}
}
