package com.lxg.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.lxg.entity.Subject;
import com.lxg.entity.Task;
import com.lxg.entity.Thesis;
import com.lxg.entity.User;
import com.lxg.service.SubjectService;
import com.lxg.service.TaskService;
import com.lxg.service.ThesisService;

@Controller
public class ThesisController extends BasicController{

	@Resource
	private SubjectService subService;
	
	@Resource
	private ThesisService service;
	
	@Resource
	private TaskService taskService;
	
	/**
	 * 导师获取毕业论文列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("ThesisList")
	public String getInternshipReportList(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		
		Task  t = taskService.getTask(user.getId(),"毕业设计");
		
		List<Subject> list = subService.getList(user.getId());
		
		request.setAttribute("page", "/WEB-INF/page/Thesis/thesis.jsp");
		
		map.addAttribute("user", user);
		map.addAttribute("task", t);
		map.addAttribute("list", list);
		return "user/index";
	}
	
	
	
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
	
	
	/**
	 * 根据学生获取
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getThesisAjax")
	public void getThesisAjax(HttpServletRequest request,PrintWriter out){
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		
		Subject subject = subService.getByStu(sid);
		
		List<Thesis> list = service.getList(sid);
		
		Thesis thesis = null;
		if(list.size() == 0){
			thesis = null;
		}else{
			thesis = list.get(0);
		}
		
		String str = JSON.toJSONString(subject)+"@LXG"+JSON.toJSONString(thesis);
		
		out.write(str);
		
	}
	
	@RequestMapping("updateThesisStatus")
	public @ResponseBody WebMessage update(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		service.update(status,id);
		
		return saveSuccess(0);
	}
	
	/**
	 * 保存毕业论文
	 * @param request
	 * @return
	 */
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
	
	/**
	 * 下载附件
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("ThesisDownload")
	public void downLoad(HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		 
		 
		String path = request.getParameter("dataPath");
		String fileName = request.getParameter("fileName");
		
		path = new String(path.getBytes("ISO-8859-1"),"UTF-8");
		
		File file = new File(path);
		
		response.setHeader("Content-disposition", "attachment;filename="
				+ fileName);
		
		response.setContentType("application/doc");
		
		long fileLength = file.length();
		String length = String.valueOf(fileLength);
		response.setHeader("Content_Length", length);
		
		
		OutputStream o = response.getOutputStream();
		byte b[] = new byte[1024];
		
		FileInputStream in = new FileInputStream(file);
		int n = 0;
		while ((n = in.read(b)) != -1) {
			o.write(b, 0, n);
		}
	}
}
