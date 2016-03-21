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
import com.lxg.entity.OpeningReport;
import com.lxg.entity.StuTask;
import com.lxg.entity.Subject;
import com.lxg.entity.Task;
import com.lxg.entity.TaskBook;
import com.lxg.entity.User;
import com.lxg.service.OpeningReportService;
import com.lxg.service.StuTaskService;
import com.lxg.service.SubjectService;
import com.lxg.service.TaskService;

/**
 * 开题报告
 * @author 李新广
 *
 * 2016年3月17日下午12:24:38
 */
@Controller
@RequestMapping("openingreport")
public class OpeningReportController extends BasicController{

	@Resource
	private OpeningReportService service;
	
	@Resource
	private StuTaskService sutTaskService;
	
	@Resource
	private SubjectService subService;
	
	@Resource
	private TaskService taskBookService;
	
	/**
	 * 保存开题报告
	 * @param request
	 */
	@RequestMapping("save")
	public @ResponseBody WebMessage save(HttpServletRequest request){
		User user = getAuthUser();
		
		String yjxz = request.getParameter("yjxz"); //研究现状
		String kxx = request.getParameter("kxx"); //可行性分析
		String jjsl = request.getParameter("jjsl"); //解决思路
		String hj = request.getParameter("hj"); //开发环境
		String schedule = request.getParameter("schedule"); //进度安排
		Date init_date = new Date(); //进表日期
		Date upd_date = new Date(); //更新日期
		Task task = taskBookService.getTask(user.getTid(),"开题报告");
		
		OpeningReport openingReport = new OpeningReport();
		
		openingReport.setSid(user.getId());
		openingReport.setYjxz(yjxz);
		openingReport.setKxx(kxx);
		openingReport.setJjsl(jjsl);
		openingReport.setHj(hj);
		openingReport.setSchedule(schedule);
		openingReport.setInit_date(init_date);
		openingReport.setUpd_date(upd_date);
		
		service.save(openingReport);
		
		StuTask stuTask = new StuTask();
		stuTask.setSid(user.getId());
		stuTask.setTid(user.getTid());
		stuTask.setTaskid(task.getId());
		stuTask.setEdate(new Date());
		
		sutTaskService.save(stuTask);
		
		return saveSuccess(0);
	}
	
	/**
	 * 根据学生id获取开题报告
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getOpeningReportStu")
	public String getOpeningReportStu(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("../toLogin");
		}
		
		request.setAttribute("page", "/WEB-INF/page/openingreport/openingreportForStu.jsp");
		
		List<OpeningReport> list = service.get(user.getId());
		Subject subject = subService.getByStu(user.getId());
		OpeningReport openingReport = null;
		if(list.size() == 0){
			openingReport = null;
		}else{
			openingReport = list.get(0);
		}
		
		map.addAttribute("user", user);
		map.addAttribute("subject", subject);
		map.addAttribute("data", openingReport);
		
		return "user/index";
	}

	/**
	 * 导师获取开题报告列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getOpeningReportList")
	public String getOpeningReportList(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("../toLogin");
		}
		
		Task  t = taskBookService.getTask(user.getId(),"开题报告");
		
		List<Subject> list = subService.getList(user.getId());
		
		request.setAttribute("page", "/WEB-INF/page/openingreport/openingReport.jsp");
		
		map.addAttribute("user", user);
		map.addAttribute("task", t);
		map.addAttribute("list", list);
		return "user/index";
	}


	/**
	 * 异步根据学id获取开题报告
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getOpeningReportAjax")
	public @ResponseBody WebMessage getOpeningReportAjax(HttpServletRequest request,ModelMap map){
		
		int userId = Integer.parseInt(request.getParameter("sid"));
		
		List<OpeningReport> list = service.get(userId);
		Subject subject = subService.getByStu(userId);
		OpeningReport openingReport = null;
		if(list.size() == 0){
			openingReport = null;
		}else{
			openingReport = list.get(0);
		}
		
		String str = JSON.toJSONString(openingReport)+"@LXG"+JSON.toJSONString(subject);
		
		return saveSuccess(str);
	}
	
	@RequestMapping("updateOpeningReportStatus")
	public @ResponseBody WebMessage update(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		String suggestion = request.getParameter("suggestion");
		
		service.update(id,suggestion, status);
		
		return saveSuccess(0);
	}
}
