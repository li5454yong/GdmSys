package com.lxg.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lxg.entity.Task;
import com.lxg.entity.User;
import com.lxg.service.TaskService;
import com.lxg.utils.DateUtil;

/**
 * 任务controller
 * 
 * @author 李新广
 *
 * 2016年3月16日下午12:47:57
 */
@Controller
public class TaskController extends BasicController{

	@Resource
	private TaskService service;
	
	/**
	 * 初始化任务
	 * @param request
	 */
	@RequestMapping("initTask")
	public String initTask(HttpServletRequest request,ModelMap map){
		
		User user = getAuthUser();
		
		service.initTask(user.getId());
		map.addAttribute("user", user);
		
		return "index";
	}
	
	/**
	 * 获取任务列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getTaskList")
	public void getTaskList(HttpServletRequest request,PrintWriter out){
		
		int tid = Integer.parseInt(request.getParameter("tid"));
		
		List<Task> list = service.getTaskList(tid);
		
		String str = JSON.toJSONString(list);
		out.print(str);
	}
	
	
	@RequestMapping("updateTask")
	public @ResponseBody WebMessage updateTask(HttpServletRequest request){
		User user = getAuthUser();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Date stime = DateUtil.getDate(request.getParameter("stime"), "yyyy-MM-DD hh:mm:ss");
		Date etime = DateUtil.getDate(request.getParameter("etime"), "yyyy-MM-DD hh:mm:ss");
		
		service.updateTask(stime,etime,1,id); //将任务状态设为进行中
		return saveSuccess(0);
	}
}
