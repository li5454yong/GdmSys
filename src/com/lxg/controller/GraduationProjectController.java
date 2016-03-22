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

/**
 * @author lxg
 *
 * 2016年3月22日下午9:08:49
 */
@Controller
public class GraduationProjectController extends BasicController {

	@Resource
	private SubjectService subService;
	
	/**
	 * 根据学生获取毕业设计
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getGraduationProjectStu")
	public String getOpeningReportStu(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("../toLogin");
		}
		
		request.setAttribute("page", "/WEB-INF/page/GraduationProject/graduationProjectForStu.jsp");
		
		Subject subject = subService.getByStu(user.getId());
		
		map.addAttribute("user", user);
		map.addAttribute("subject", subject);
		
		return "user/index";
	}
}
