package com.lxg.dao;

import java.util.List;

import com.lxg.entity.Subject;


public interface SubjectDao {
	
	public List<Subject> getList(int tid);
	
	public List<Subject> getList();
	
	public void save(Subject s);
	
	public void update(String sql,Object... objects);
	
	public Subject get(int id);
	
	public Subject getByStu(int sid);
	
	public void update(Subject subject);
}
