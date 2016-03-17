package com.lxg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 任务书
 * @author 李新广
 *
 * 2016年3月17日下午1:34:51
 */
@Entity
public class TaskBook {
	private int id;
	
	private String title; //任务名称
	
	private int sid; //学生id
	
	private String objective; //研究意义及目的
	
	private String content; //主要内容及技术
	
	private String olddata; //原始数据及资料
	
	private String schedule; //进度安排
	
	private String literature; //参考文献
	
	private String eliterature; //英文参考文献
	
	private Date init_date; //发布日期
	
	private int status; //状态 0-待审核   1-合格   2-不合格

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOlddata() {
		return olddata;
	}

	public void setOlddata(String olddata) {
		this.olddata = olddata;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getLiterature() {
		return literature;
	}

	public void setLiterature(String literature) {
		this.literature = literature;
	}

	public String getEliterature() {
		return eliterature;
	}

	public void setEliterature(String eliterature) {
		this.eliterature = eliterature;
	}

	public Date getInit_date() {
		return init_date;
	}

	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
