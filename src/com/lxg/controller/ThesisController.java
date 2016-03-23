package com.lxg.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lxg.entity.Subject;
import com.lxg.entity.Thesis;
import com.lxg.entity.User;
import com.lxg.service.SubjectService;
import com.lxg.service.ThesisService;

@Controller
public class ThesisController extends BasicController{

	@Resource
	private SubjectService subService;
	
	@Resource
	private ThesisService service;
	
	/**
	 * 根据学生获取
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getThesisByStu")
	public String getThesisByStu(HttpServletRequest request,ModelMap map){
		
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		
		request.setAttribute("page", "/WEB-INF/page/Thesis/thesisForStu.jsp");
		
		Subject subject = subService.getByStu(user.getId());
		
		List<Thesis> list = service.getList(user.getId());
		
		Thesis thesis = null;
		if(list.size() == 0){
			thesis = null;
		}else{
			thesis = list.get(0);
		}
		map.addAttribute("user", user);
		map.addAttribute("subject", subject);
		map.addAttribute("data", thesis);
		
		return "user/index";
		
	}
	
	@RequestMapping("ThesisSave")
	public String save(MultipartHttpServletRequest request){
		
		User user = getAuthUser();
		
		String title = request.getParameter("title"); //论文题目
		String etitle = request.getParameter("etitle"); //英文题目
		String gjz = request.getParameter("gjz"); //关键字
		String egjz = request.getParameter("egjz"); //英文关键字
		String zy = request.getParameter("zy"); //摘要
		String ezy = request.getParameter("ezy"); //英文摘要
		
		MultipartFile multipartFile = request.getFile("file");
		
		if (multipartFile != null) {
			String fileName = multipartFile.getOriginalFilename();
			
			File file = new File("D:/GdmSys/thesis/"+fileName);
			try {
				
				multipartFile.transferTo(file);
				
				Thesis thesis = new Thesis();
				
				thesis.setEgjz(egjz);
				thesis.setEtitle(etitle);
				thesis.setEzy(ezy);
				thesis.setGjz(gjz);
				thesis.setInit_date(new Date());
				thesis.setTitle(title);
				thesis.setZy(zy);
				thesis.setSid(user.getId());
				thesis.setPath("D:/GdmSys/thesis/"+fileName);
				thesis.setFileName(fileName);
				
				service.save(thesis);
				
			}catch(Exception e){
				
			}
		}
		
		return redirect("getThesisByStu");
	}
}
