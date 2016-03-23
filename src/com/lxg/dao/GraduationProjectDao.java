package com.lxg.dao;

import java.util.List;

import com.lxg.entity.GraduationProject;

public interface GraduationProjectDao {

	public void save(GraduationProject po);
	
	public List<GraduationProject> get(int sid);
	
	public void update(int status, int id);
}
