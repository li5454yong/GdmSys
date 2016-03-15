package com.lxg.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else{
		
		}
	}
	
}
