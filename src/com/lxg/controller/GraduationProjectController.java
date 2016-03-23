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
import com.lxg.entity.GraduationProject;
import com.lxg.entity.Subject;
import com.lxg.entity.Task;
import com.lxg.entity.User;
import com.lxg.service.GraduationProjectService;
import com.lxg.service.SubjectService;
import com.lxg.service.TaskService;

/**
 * @author lxg
 *
 * 2016年3月22日下午9:08:49
 */
@Controller
public class GraduationProjectController extends BasicController {

	@Resource
	private SubjectService subService;
	
	@Resource
	private GraduationProjectService service;
	
	@Resource
	private TaskService taskService;
	
	/**
	 * 导师获取毕业设计列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getGraduationProjectList")
	public String getInternshipReportList(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		
		Task  t = taskService.getTask(user.getId(),"毕业设计");
		
		List<Subject> list = subService.getList(user.getId());
		
		request.setAttribute("page", "/WEB-INF/page/GraduationProject/graduationProject.jsp");
		
		map.addAttribute("user", user);
		map.addAttribute("task", t);
		map.addAttribute("list", list);
		return "user/index";
	}
	
	
	
	
	
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
			return redirect("toLogin");
		}
		
		request.setAttribute("page", "/WEB-INF/page/GraduationProject/graduationProjectForStu.jsp");
		
		Subject subject = subService.getByStu(user.getId());
		
		List<GraduationProject> list = service.get(user.getId());
		
		GraduationProject project = null;
		if(list.size() == 0){
			project = null;
		}else{
			project = list.get(0);
		}
		map.addAttribute("user", user);
		map.addAttribute("subject", subject);
		map.addAttribute("data", project);
		
		return "user/index";
	}
	
	
	/**
	 * 根据学生异步获取毕业设计
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getGraduationProjectAjax")
	public void getOpeningReportAjax(HttpServletRequest request,PrintWriter out){
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		Subject subject = subService.getByStu(sid);
		
		List<GraduationProject> list = service.get(sid);
		
		GraduationProject project = null;
		if(list.size() == 0){
			project = null;
		}else{
			project = list.get(0);
		}
		String str = JSON.toJSONString(subject)+"@LXG"+JSON.toJSONString(project);
		
		out.write(str);
	}
	
	@RequestMapping("graduationProjectSave")
	public String save(MultipartHttpServletRequest request) throws Exception{

		User user = getAuthUser();
		
		MultipartFile multipartFile = request.getFile("files");
		String isHave = request.getParameter("isHave");
		if (multipartFile != null) {
			String fileName = multipartFile.getOriginalFilename();
			
			File file = new File("D:/GdmSys/"+fileName);
			try {
				
				multipartFile.transferTo(file);
				GraduationProject  po = new GraduationProject();
				po.setDataPath("D:/GdmSys/"+fileName);
				po.setIsHave(Integer.parseInt(isHave));
				po.setSid(user.getId());
				po.setInit_date(new Date());
				po.setFileName(fileName);
				service.save(po);
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return redirect("getGraduationProjectStu");
		}else{
			return redirect("getGraduationProjectStu");
		}
	
	}
	
	/**
	 * 下载附件
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("GraduationProjectDownload")
	public void downLoad(HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		 
		 
		String path = request.getParameter("dataPath");
		String fileName = request.getParameter("fileName");
		
		path = new String(path.getBytes("ISO-8859-1"),"UTF-8");
		
		File file = new File(path);
		
		response.setHeader("Content-disposition", "attachment;filename="
				+ fileName);
		
		response.setContentType("application/zip");
		
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
	
	
	@RequestMapping("updateProjectStatus")
	public @ResponseBody WebMessage update(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		service.update(status,id);
		
		return saveSuccess(0);
	}
	
}
