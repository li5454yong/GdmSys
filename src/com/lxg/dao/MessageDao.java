package com.lxg.dao;

import java.util.List;

import com.lxg.entity.Message;

/**
 * @author lxg
 *
 * 2016年3月16日下午9:57:42
 */
public interface MessageDao {
	
	public void save(Message po);
	
	public List<Message> getList(int tid);
}
