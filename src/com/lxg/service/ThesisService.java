package com.lxg.service;

import java.util.List;

import com.lxg.entity.Thesis;

public interface ThesisService {
	
	public List<Thesis> getList(int sid);
	
	public void save(Thesis po);
	
	public void update(int status,int id);
}
