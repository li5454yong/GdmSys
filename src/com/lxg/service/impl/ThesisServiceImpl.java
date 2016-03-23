package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.ThesisDao;
import com.lxg.entity.Thesis;
import com.lxg.service.ThesisService;

@Service
public class ThesisServiceImpl implements ThesisService {

	@Resource
	private ThesisDao dao;
	
	public List<Thesis> getList(int sid) {
		
		return dao.getList(sid);
		
	}

	
	public void save(Thesis po) {
		dao.save(po);
	}


	public void update(int status, int id) {
		
		dao.update(status, id);
	}

}
