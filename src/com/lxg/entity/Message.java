package com.lxg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 通知消息
 * @author lxg
 *
 * 2016年3月16日下午9:44:45
 */
@Entity
public class Message {

	private int id;
	
	private int tid; //导师id
	
	private String content; //消息内容
	
	private Date init_date;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInit_date() {
		return init_date;
	}

	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}
	
	

}
