package com.lxg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.MessageDao;
import com.lxg.entity.Message;
import com.lxg.service.MessageService;

/**
 * 导师发布通知消息
 * @author lxg
 *
 * 2016年3月16日下午9:56:49
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageDao dao;
	
	public void save(Message po) {
		dao.save(po);

	}

	/**
	 * 获取消息列表
	 */
	public List<Message> getList(int tid) {
		
		return dao.getList(tid);
	}

}
