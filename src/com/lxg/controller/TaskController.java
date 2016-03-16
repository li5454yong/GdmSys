package com.lxg.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void initTask(HttpServletRequest request){
		
		User user = getAuthUser();
		
		service.initTask(user.getId());
		
	}
	
	/**
	 * 获取任务列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getTaskList")
	public String getTaskList(HttpServletRequest request,ModelMap map){
		
		int tid = Integer.parseInt(request.getParameter("tid"));
		
		List<Task> list = service.getTaskList(tid);
		
		map.addAttribute("taskList", list);
		return "";
	}
	
	
	@RequestMapping("updateTask")
	public String updateTask(HttpServletRequest request){
		User user = getAuthUser();
		
		Date stime = DateUtil.getDate(request.getParameter("stime"), "");
		Date etime = DateUtil.getDate(request.getParameter("etime"), "");
		
		service.updateTask(stime,etime,1,user.getId()); //将任务状态设为进行中
		return "";
	}
}
