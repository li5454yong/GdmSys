package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.GraduationProjectDao;
import com.lxg.entity.GraduationProject;
import com.lxg.service.GraduationProjectService;

@Service
public class GraduationProjectServiceImpl implements GraduationProjectService {

	@Resource
	private GraduationProjectDao dao;
	
	public void save(GraduationProject po) {
		dao.save(po);
	}

	
	public List<GraduationProject> get(int sid) {
		
		return dao.get(sid);
	}


	public void update(int status, int id) {
		dao.update(status,id);
	}

}
