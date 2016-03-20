package com.lxg.service;

import java.util.List;

import com.lxg.entity.Subject;


public interface SubjectService {
	
	public List<Subject> getList(int tid);
	
	public List<Subject> getList();
	
	public void save(Subject s);
	
	public void update(Object... objects);
	
	public void update(Subject subject);
	
	public Subject get(int id);
	
	public Subject getByStu(int sid);
}
