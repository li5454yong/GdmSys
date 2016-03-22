package com.lxg.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lxg.entity.InternshipReport;
import com.lxg.entity.Subject;
import com.lxg.entity.Task;
import com.lxg.entity.User;
import com.lxg.service.InternshipReportService;
import com.lxg.service.SubjectService;
import com.lxg.service.TaskService;

/**
 * @author lxg
 *
 * 2016年3月21日下午9:03:30
 */
@Controller
public class InternshipReportController extends BasicController{

	@Resource
	private SubjectService subService;
	
	@Resource
	private InternshipReportService internshipReportService;
	
	@Resource
	private TaskService taskBookService;
	/**
	 * 根据学生获取
	 */
	@RequestMapping("getIrByStu")
	public String get(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		request.setAttribute("page", "/WEB-INF/page/internshipreport/internshipreportForStu.jsp");
		//Subject subject = subService.getByStu(user.getId());
		
		List<InternshipReport> list = internshipReportService.get(user.getId());
		InternshipReport internshipReport = null;
		if(list.size() == 0){
			internshipReport = null;
		}else{
			internshipReport = list.get(0);
		}
		
		map.addAttribute("user", user);
		map.addAttribute("data", internshipReport);
		
		return "user/index";
	}
	
	
	@RequestMapping("getIrByStuForAjax")
	public @ResponseBody WebMessage get(HttpServletRequest request){
		User user = getAuthUser();
		//Subject subject = subService.getByStu(user.getId());
		int id = Integer.parseInt(request.getParameter("sid"));
		List<InternshipReport> list = internshipReportService.get(id);
		InternshipReport internshipReport = null;
		if(list.size() == 0){
			internshipReport = null;
		}else{
			internshipReport = list.get(0);
		}
		
		String str = JSON.toJSONString(internshipReport);
		
		return saveSuccess(str);
	}
	
	
	@RequestMapping("updateStatus")
	public @ResponseBody WebMessage update(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		internshipReportService.update(status,id);
		
		return saveSuccess(0);
	}
	
	/**
	 * 导师获取开题报告列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getInternshipReportList")
	public String getInternshipReportList(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		
		Task  t = taskBookService.getTask(user.getId(),"实习报告");
		
		List<Subject> list = subService.getList(user.getId());
		
		request.setAttribute("page", "/WEB-INF/page/internshipreport/internshipReport.jsp");
		
		map.addAttribute("user", user);
		map.addAttribute("task", t);
		map.addAttribute("list", list);
		return "user/index";
	}
	
	
	/**
	 * 保存实习报告
	 * @param request
	 * @return
	 */
	@RequestMapping("internshipReportSave")
	public @ResponseBody WebMessage save(HttpServletRequest request){
		User user = getAuthUser();
		
		String qyds = request.getParameter("qyds"); //企业导师
		String zw = request.getParameter("zw"); //导师职务
		String xl = request.getParameter("xl"); //学历
		String dszy = request.getParameter("dszy"); //导师专业
		String email = request.getParameter("email"); //导师邮箱
		String phonenum = request.getParameter("phonenum"); //导师电话
		String dwemail = request.getParameter("dwemail"); //企业邮箱
		String dwphone = request.getParameter("dwphone");//单位电话
		String dwsf = request.getParameter("dwsf");//单位省份
		String dwmc = request.getParameter("dwmc"); //单位名称
		String dwdz = request.getParameter("dwdz"); //单位地址
		String sxnr = request.getParameter("sxnr");//实习内容
		String sxzj = request.getParameter("sxzj"); //实习总结
		
		InternshipReport internshipReport = new InternshipReport();
		
		internshipReport.setDszy(dszy);
		internshipReport.setDwdz(dwdz);
		internshipReport.setDwemail(dwemail);
		internshipReport.setDwmc(dwmc);
		internshipReport.setDwphone(dwphone);
		internshipReport.setDwsf(dwsf);
		internshipReport.setEmail(email);
		internshipReport.setPhonenum(phonenum);
		internshipReport.setQyds(qyds);
		internshipReport.setSxnr(sxnr);
		internshipReport.setSxzj(sxzj);
		internshipReport.setXl(xl);
		internshipReport.setZw(zw);
		internshipReport.setSid(user.getId());
		
		internshipReportService.save(internshipReport);
		
		return saveSuccess(0);
	}
}
