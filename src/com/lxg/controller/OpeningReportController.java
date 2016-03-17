package com.lxg.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxg.entity.OpeningReport;
import com.lxg.entity.StuTask;
import com.lxg.entity.User;
import com.lxg.service.OpeningReportService;
import com.lxg.service.StuTaskService;

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
	
	/**
	 * 保存开题报告
	 * @param request
	 */
	@RequestMapping("save")
	public void save(HttpServletRequest request){
		User user = getAuthUser();
		
		String yjxz = request.getParameter("yjxz"); //研究现状
		String kxx = request.getParameter("kxx"); //可行性分析
		String jjsl = request.getParameter("jjsl"); //解决思路
		String hj = request.getParameter("hj"); //开发环境
		String schedule = request.getParameter("schedule"); //进度安排
		Date init_date = new Date(); //进表日期
		Date upd_date = new Date(); //更新日期
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		
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
		stuTask.setTaskid(taskId);
		stuTask.setEdate(new Date());
		
		sutTaskService.save(stuTask);
	}
}
