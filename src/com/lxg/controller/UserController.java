package com.lxg.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.lxg.entity.User;
import com.lxg.service.UserService;
import com.lxg.utils.MD5;

/**
 * 
 * @author lxg
 *
 * 2016年3月14日下午8:14:59
 */

@Controller
public class UserController extends BasicController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping("login")
	public void login(HttpServletRequest request ,HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = MD5.MD5Encode(request.getParameter("password"));
		int power = Integer.parseInt(request.getParameter("power"));
		
		List<User> l = userService.login(username);
		if(l.size() == 1){
			User u = l.get(0);
			if(u.getPasswd().equals(password)){
				if(u.getPower() == power){
					request.getSession().setAttribute("USER",u);
					response.getWriter().print("0");//登录成功
				}else{
					response.getWriter().print("3");//身份错误
				}
				
			}else{
				response.getWriter().print("2");//密码错误
			}
		}else{
			response.getWriter().print("1");//用户名不存在
		}
	}
	
	@RequestMapping("toIndex")
	public String toIndex(ModelMap map){
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		map.addAttribute("user", user);
		return "index";
	}
	
	//跳转到登录页面
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}
	
	/**
	 * 获取当前用户的进度
	 */
	@RequestMapping("getSchedule")
	public void getSchedule(){
		
	}
	
	/**
	 * 跳转到上传头像页面
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("toUploadImg")
	public String toUploadImg(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		request.setAttribute("page", "/WEB-INF/page/user/imgUpload.jsp");
		if(user == null){
			return redirect("toLogin");
		}
		map.addAttribute("user", user);
		return "user/index";
	}
	
	/**
	 * 上传头像
	 * @param request
	 */
	@RequestMapping("uploadImg")
	public void uploadImg(HttpServletRequest request ,PrintWriter out){
		User user = getAuthUser();
		
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		Iterator<String> t = multiRequest.getFileNames();
		MultipartFile fileDetail = multiRequest.getFile(t.next());
		String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/images/user/";
		if (fileDetail != null) {
			String fileName = fileDetail.getOriginalFilename();
			Result result = new Result();
			
			try {
				File file = new File("D:\\tomcat\\apache-tomcat-7.0.57\\webapps\\images\\user\\"+user.getStu_num()+".png");
				
				fileDetail.transferTo(file);
				userService.updatePic(user.getId(),realPath+user.getStu_num()+".png");
				result.success = true;
				result.msg = "Success!";
				user.setPic(realPath+user.getStu_num()+".png");
				request.getSession().setAttribute("USER",user);
				
				out.println(JSON.toJSONString(result));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("toUserInfo")
	public String toUserInfo(HttpServletRequest request,ModelMap map){
		User user = getAuthUser();
		request.setAttribute("page", "/WEB-INF/page/user/userInfo.jsp");
		if(user == null){
			return redirect("toLogin");
		}
		map.addAttribute("user", user);
		return "user/index";
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param out
	 */
	@RequestMapping("editPw")
	public void editPw(HttpServletRequest request,PrintWriter out){
		User user = getAuthUser();
		
		String oldPw = request.getParameter("oldPw");
		String newPw = request.getParameter("passwd");
		
		if(MD5.MD5Encode(oldPw).equals(user.getPasswd())){
			userService.updatePW(user.getId(), newPw);
			out.write("0");; //修改成功
		}else{
			out.write("1"); //原始密码错误
		}
	}
	
	
	private class Result
	{
		/**
		* 表示图片是否已上传成功。
		*/
		public Boolean success;
		public String userid;
		public String username;
		/**
		* 自定义的附加消息。
		*/
		public String msg;
		/**
		* 表示原始图片的保存地址。
		*/
		public String sourceUrl;
		/**
		* 表示所有头像图片的保存地址，该变量为一个数组。
		*/
		public ArrayList avatarUrls;
	}
}


