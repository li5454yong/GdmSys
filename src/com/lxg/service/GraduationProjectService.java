package com.lxg.service;

import java.util.List;

import com.lxg.entity.GraduationProject;


public interface GraduationProjectService {
	
	public void save(GraduationProject po);
	
	public List<GraduationProject> get(int sid);
	
	public void update(int status,int id);
}
