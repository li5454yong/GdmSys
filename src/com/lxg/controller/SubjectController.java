package com.lxg.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxg.entity.Subject;
import com.lxg.entity.User;
import com.lxg.service.SubjectService;
import com.lxg.service.UserService;
/**
 * 课题
 * @author 李新广
 *
 * 2016年3月17日下午1:33:28
 */
@Controller
@RequestMapping("subject")
public class SubjectController extends BasicController{

	@Resource
	private SubjectService service;
	
	@Resource
	private UserService userService;
	/**
	 * 根据导师获取课题列表
	 * @param request
	 * @param map
	 */
	@SuppressWarnings("unused")
	@RequestMapping("getListForTeacher")
	public String getList(HttpServletRequest request,ModelMap map){
		
		User user = getAuthUser();
		if(user == null){
			return redirect("../toLogin");
		}
		
		request.setAttribute("page", "/WEB-INF/page/subject/subjectList.jsp");
		List<Subject> list = service.getList(user.getId());
		
		
		map.addAttribute("user", user);
		map.addAttribute("list", list);
		return "user/index";
	}
	
	/**
	 * 获取全部课题列表
	 * @param request
	 * @param map
	 */
	@RequestMapping("getListForStu")
	public String getList1(HttpServletRequest request ,ModelMap map){
		
		User user = getAuthUser();
		if(user == null){
			return redirect("../toLogin");
		}
		
		request.setAttribute("page", "/WEB-INF/page/subject/subjectList1.jsp");
		
		List<Subject> list = service.getList();
		
		map.addAttribute("user", user);
		map.addAttribute("list", list);
		return "user/index";
	}
	
	/**
	 * 新增课题
	 * @param request
	 */
	@RequestMapping("save")
	public @ResponseBody WebMessage save(HttpServletRequest request){
		
		User user = getAuthUser();
		
		String title = request.getParameter("title");//课题名称
		
		int num = Integer.parseInt(request.getParameter("num")); //可选人数
		String desc = request.getParameter("desc");//课题简介
		String expected_target = request.getParameter("expected_target");//预期目标
		String demand = request.getParameter("demand");//能力要求
		String condition = request.getParameter("condition"); //所需条件
		String literature = request.getParameter("literature"); //参考文献
		
		Subject s = new Subject();
		
		s.setCondition1(condition);
		s.setDemand(demand);
		s.setDesc1(desc);
		s.setExpected_target(expected_target);
		s.setLiterature(literature);
		s.setNum(num);
		s.setStatus(0);
		s.setTid(user.getId());
		s.setTitle(title);
		s.setTname(user.getName());
		s.setInit_date(new Date());
		
		service.save(s);
		
		return saveSuccess(0);
	}

	
	/**
	 * 选择课题
	 * @param request
	 */
	@RequestMapping("selectSubject")
	public @ResponseBody WebMessage selectSubject(HttpServletRequest request){
		User user = getAuthUser();
		
		int tid = Integer.parseInt(request.getParameter("tid"));
		String tname = request.getParameter("tname");
		
		int id = Integer.parseInt(request.getParameter("id"));
		service.update(user.getId(),user.getName(),id);
		
		userService.updateTeacher(user.getId(), tid, tname); //修改学生的导师信息
		user.setTid(tid);
		user.setTname(tname);
		request.getSession().setAttribute("USER",user);
		
		return saveSuccess(0);
	}

	/**
	 * 获取课题
	 * @param id
	 * @return
	 */
	@RequestMapping("get")
	public @ResponseBody WebMessage get(int id){
		
		Subject subject = service.get(id);
		return saveSuccess(subject);
	}
	
	/**
	 * 修改课题
	 * @param request
	 */
	@RequestMapping("update")
	public @ResponseBody WebMessage update(HttpServletRequest request){
		
		String title = request.getParameter("title");//课题名称
		
		int num = Integer.parseInt(request.getParameter("num")); //可选人数
		String desc = request.getParameter("desc");//课题简介
		String expected_target = request.getParameter("expected_target");//预期目标
		String demand = request.getParameter("demand");//能力要求
		String condition = request.getParameter("condition"); //所需条件
		String literature = request.getParameter("literature"); //参考文献
		int id = Integer.parseInt(request.getParameter("id"));
		
		Subject s = service.get(id);
		
		s.setId(id);
		s.setCondition1(condition);
		s.setDemand(demand);
		s.setDesc1(desc);
		s.setExpected_target(expected_target);
		s.setLiterature(literature);
		s.setNum(num);
		s.setStatus(0);
		s.setTitle(title);
		
		service.update(s);
		
		return saveSuccess(0);
	}
}
