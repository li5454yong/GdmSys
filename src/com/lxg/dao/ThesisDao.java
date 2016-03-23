package com.lxg.dao;

import java.util.List;

import com.lxg.entity.Thesis;

public interface ThesisDao {

	public List<Thesis> getList(int sid);
	
	public void save(Thesis po);
}
