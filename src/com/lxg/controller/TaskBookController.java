package com.lxg.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lxg.entity.Subject;
import com.lxg.entity.Task;
import com.lxg.entity.TaskBook;
import com.lxg.entity.User;
import com.lxg.service.SubjectService;
import com.lxg.service.TaskBookService;
import com.lxg.service.TaskService;
import com.lxg.utils.DateUtil;

/**
 * @author lxg
 *
 * 2016年3月17日下午8:19:07
 */
@Controller
public class TaskBookController extends BasicController {

	@Resource
	private TaskBookService service;
	
	@Resource
	private TaskService taskService;
	
	@Resource
	private SubjectService subService;
	
	/**
	 * 获取课题列表，供教师根据课题查看相应任务书
	 * @param request
	 */
	@RequestMapping("getTaskBook")
	public String get(HttpServletRequest request,ModelMap map){
		//int tid = Integer.parseInt(request.getParameter("tid"));
		
		
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		
		Task  t = taskService.getTask(user.getId(),"任务书");
		
		List<Subject> list = subService.getList(user.getId());
		
		request.setAttribute("page", "/WEB-INF/page/taskBook/taskBook.jsp");
		
		map.addAttribute("user", user);
		map.addAttribute("task", t);
		map.addAttribute("list", list);
		return "user/index";
	}
	
	
	@RequestMapping("getTaskBookTea")
	public @ResponseBody WebMessage getTaskBookTea(HttpServletRequest request,ModelMap map){
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		TaskBook book = service.get(sid);
		Subject subject = subService.getByStu(sid);
		
		String str = JSON.toJSONString(book)+"@LXG"+JSON.toJSONString(subject);
		
		return saveSuccess(str);
	}
	/**
	 * 根据学生获取任务书
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getTaskBookStu")
	public String getTaskBookStu(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		
		TaskBook book = service.get(user.getId());
		Subject subject = subService.getByStu(user.getId());
		
		
		request.setAttribute("page", "/WEB-INF/page/taskBook/taskBookForStu.jsp");
		
		map.addAttribute("user", user);
		map.addAttribute("data", book);
		map.addAttribute("subject", subject);
		
		return "user/index";
	}
	
	/**
	 * 保存任务书
	 * @param request
	 */
	@RequestMapping("saveTaskBook")
	public @ResponseBody WebMessage saveTaskBook(HttpServletRequest request){
		User user = getAuthUser();
		
		String title = request.getParameter("title"); //任务名称
		
		String objective = request.getParameter("objective"); //研究意义及目的
		String content = request.getParameter("content"); //主要内容及技术
		String olddata = request.getParameter("olddata"); //原始数据及资料
		String schedule = request.getParameter("schedule"); //进度安排
		String literature = request.getParameter("literature"); //参考文献
		String eliterature = request.getParameter("eliterature"); //英文参考文献
		Date init_date = DateUtil.getDate(request.getParameter("init_date"), "yyyy-MM-dd hh:mm:ss");; //发布日期
		
		TaskBook taskBook = new TaskBook();
		
		taskBook.setContent(content);
		taskBook.setEliterature(eliterature);
		taskBook.setInit_date(init_date);
		taskBook.setLiterature(literature);
		taskBook.setObjective(objective);
		taskBook.setOlddata(olddata);
		taskBook.setSchedule(schedule);
		taskBook.setTitle(title);
		taskBook.setSid(user.getId());
		
		service.save(taskBook);
		return saveSuccess(0);
	}
	
	@RequestMapping("updateTaskBookStatus")
	public @ResponseBody WebMessage update(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		service.update(id, status);
		
		return saveSuccess(0);
	}
}
