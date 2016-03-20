package com.lxg.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lxg.entity.User;
import com.lxg.service.UserService;
import com.lxg.utils.Excel;
import com.lxg.utils.MD5;


/**
 * 系统管理员
 * @author 李新广
 *
 * 2016年3月15日上午9:53:47
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BasicController{

	@Resource
	private UserService userService;
	/**
	 * excel文件导入
	 * @param request
	 * @param out
	 */
	@RequestMapping("upload")
	public void upload(HttpServletRequest request, PrintWriter out){
		
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		Iterator<String> t = multiRequest.getFileNames();
		MultipartFile fileDetail = multiRequest.getFile(t.next());
		
		if (fileDetail != null) {
			String fileName = fileDetail.getOriginalFilename();
			
			try {
				FileInputStream in = (FileInputStream)fileDetail.getInputStream();
				Excel excel = new Excel();
				
				List<User> list = excel.readExcel(in, fileName);
				
				for(User u : list){
					u.setPasswd(MD5.MD5Encode(u.getPasswd()));
					userService.save(u);
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		}else{
		
		}
	}
	
	/**
	 * 跳转到用户导入页面
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("toImport")
	public String toImport(HttpServletRequest request,ModelMap map){
		
		User user = getAuthUser();
		request.setAttribute("page", "/WEB-INF/page/user/importUser.jsp");
		if(user == null){
			return redirect("../toLogin");
		}
		map.addAttribute("user", user);
		return "user/index";
	}
	
	/**
	 * 获取学生列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getStuList")
	public String getStuList(HttpServletRequest request,ModelMap map){
		
		User user = getAuthUser();
		request.setAttribute("page", "/WEB-INF/page/user/stuList.jsp");
		if(user == null){
			return redirect("../toLogin");
		}
		
		List<User> list = userService.getList(2);
		map.addAttribute("data", list);
		map.addAttribute("user", user);
		return "user/index";
		
	}
	/**
	 * 获取教师列表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("getTeaList")
	public String getTeaList(HttpServletRequest request,ModelMap map){
		
		User user = getAuthUser();
		request.setAttribute("page", "/WEB-INF/page/user/teacherList.jsp");
		if(user == null){
			return redirect("../toLogin");
		}
	
		List<User> list = userService.getList(1);
		map.addAttribute("data", list);
		map.addAttribute("user", user);
		return "user/index";
		
	}
	
	/**
	 * 重置密码
	 * @param id
	 * @return
	 */
	@RequestMapping("reSetPw")
	public @ResponseBody WebMessage reSetPw(int id){
		userService.updatePW(id, "111111");
		return saveSuccess(1);//修改成功
		
	}
}
