package com.lxg.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxg.entity.DailyLog;
import com.lxg.entity.Subject;
import com.lxg.entity.Task;
import com.lxg.entity.User;
import com.lxg.service.DailyLogService;
import com.lxg.service.SubjectService;
import com.lxg.service.TaskService;
import com.lxg.utils.DateUtil;

@Controller
public class DailyLogController extends BasicController {

	@Resource
	private DailyLogService service;
	
	@Resource
	private TaskService taskService;
	@Resource
	private SubjectService subService;
	
	/**
	 * 导师获取工作日志列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("dailyLogList")
	public String dailyLogListForTea(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		
		Task  t = taskService.getTask(user.getId(),"工作日志");
		
		List<Subject> list = subService.getList(user.getId());
		
		request.setAttribute("page", "/WEB-INF/page/DailyLog/dailyLog.jsp");
		
		map.addAttribute("user", user);
		map.addAttribute("task", t);
		map.addAttribute("list", list);
		return "user/index";
	}
	
	/**
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getDailyLogList")
	public String getDailyLogList(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		String sid = request.getParameter("sid");
		request.setAttribute("page", "/WEB-INF/page/DailyLog/dailyLogForStu.jsp");
		List<DailyLog> list = null;
		if(user.getPower() == 1){
			
			list = service.list(Integer.parseInt(sid));
			
		}else{
			
			list = service.list(user.getId());
			
		}
		
		
		map.addAttribute("user", user);
		map.addAttribute("list", list);
		
		return "user/index";
	}
	
	@RequestMapping("dailyLogSave")
	public String save(HttpServletRequest request){
		User user = getAuthUser();
		
		String content = request.getParameter("content");
		
		Date init_date = DateUtil.getDate(request.getParameter("init_date"), "yyyy-MM-dd hh:mm:ss");
		
		DailyLog dailyLog = new DailyLog();
		
		dailyLog.setContent(content);
		dailyLog.setInit_date(init_date);
		dailyLog.setSid(user.getId());
		
		service.save(dailyLog);
		
		return redirect("getDailyLogList");
	}
}
