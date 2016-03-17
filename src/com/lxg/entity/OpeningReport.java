package com.lxg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 开题报告
 * @author 李新广
 *
 * 2016年3月17日上午10:44:01
 */
@Entity
public class OpeningReport {

	private int id;
	
	private int sid; // 学生id
	
	private String yjxz; //研究现状
	
	private String kxx; //可行性分析
	
	private String jjsl; //解决思路
	
	private String hj; //开发环境
	
	private String schedule; //进度安排
	
	private Date init_date; //进表日期
	
	private Date upd_date; //更新日期
	
	private int status; //状态
	
	private String suggestion; //导师意见
	
	private int checkstatus; //审核状态

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getYjxz() {
		return yjxz;
	}

	public void setYjxz(String yjxz) {
		this.yjxz = yjxz;
	}

	public String getKxx() {
		return kxx;
	}

	public void setKxx(String kxx) {
		this.kxx = kxx;
	}

	public String getJjsl() {
		return jjsl;
	}

	public void setJjsl(String jjsl) {
		this.jjsl = jjsl;
	}

	public String getHj() {
		return hj;
	}

	public void setHj(String hj) {
		this.hj = hj;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Date getInit_date() {
		return init_date;
	}

	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}

	public Date getUpd_date() {
		return upd_date;
	}

	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public int getCheckstatus() {
		return checkstatus;
	}

	public void setCheckstatus(int checkstatus) {
		this.checkstatus = checkstatus;
	}

	
}
