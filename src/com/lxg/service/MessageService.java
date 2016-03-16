package com.lxg.service;

import java.util.List;

import com.lxg.entity.Message;

/**
 * @author lxg
 *
 * 2016年3月16日下午9:47:34
 */
public interface MessageService {

	public void save(Message po);
	
	public List<Message> getList(int tid);
}
