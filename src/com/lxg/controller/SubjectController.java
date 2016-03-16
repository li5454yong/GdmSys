package com.lxg.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxg.entity.Subject;
import com.lxg.entity.User;
import com.lxg.service.SubjectService;
import com.lxg.service.UserService;

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
	@RequestMapping("getListForTeacher")
	public void getList(HttpServletRequest request,ModelMap map){
		
		User user = getAuthUser();
		
		List<Subject> list = service.getList(user.getId());
		
		map.addAttribute("list", list);
	}
	
	/**
	 * 获取全部课题列表
	 * @param request
	 * @param map
	 */
	@RequestMapping("getListForStu")
	public void getList1(HttpServletRequest request ,ModelMap map){
		
		List<Subject> list = service.getList();
		
		map.addAttribute("list", list);
		
	}
	
	/**
	 * 新增课题
	 * @param request
	 */
	@RequestMapping("save")
	public void save(HttpServletRequest request){
		
		User user = getAuthUser();
		
		String title = request.getParameter("title");//课题名称
		
		int num = Integer.parseInt(request.getParameter("num")); //可选人数
		String desc = request.getParameter("desc");//课题简介
		String expected_target = request.getParameter("expected_target");//预期目标
		String demand = request.getParameter("demand");//能力要求
		String condition = request.getParameter("condition"); //所需条件
		String literature = request.getParameter("literature"); //参考文献
		int status; //是否可选
		
		Subject s = new Subject();
		
		s.setCondition(condition);
		s.setDemand(demand);
		s.setDesc(desc);
		s.setExpected_target(expected_target);
		s.setLiterature(literature);
		s.setNum(num);
		s.setStatus(0);
		s.setTid(user.getId());
		s.setTitle(title);
		s.setTname(user.getName());
		
		service.save(s);
	}

	
	/**
	 * 选择课题
	 * @param request
	 */
	@RequestMapping("selectSubject")
	public void selectSubject(HttpServletRequest request){
		User user = getAuthUser();
		
		int tid = Integer.parseInt(request.getParameter("tid"));
		String tname = request.getParameter("tname");
		
		int id = Integer.parseInt(request.getParameter("id"));
		service.update(user.getId(),user.getName(),id);
		
		userService.updateTeacher(id, tid, tname); //修改学生的导师信息
	}

}
