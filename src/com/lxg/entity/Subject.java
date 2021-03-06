package com.lxg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 课题表
 * @author 李新广
 *
 * 2016年3月16日上午10:13:01
 */
@Entity
public class Subject {

	private int id;
	
	private String title;//课题名称
	
	private int num; //可选人数
	
	private int tid;//导师id
	
	private String tname;//导师姓名
	
	private int sid;//学生id
	
	private String  sname;//学生姓名
	
	private String desc1;//课题简介
	
	private String expected_target;//预期目标
	
	private String demand;//能力要求
	
	private String condition1; //所需条件
	
	private String literature; //参考条件
	
	private int status; //是否可选 0-可选    1-不可选
	
	private Date init_date;

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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getExpected_target() {
		return expected_target;
	}

	public void setExpected_target(String expected_target) {
		this.expected_target = expected_target;
	}

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}



	public String getCondition1() {
		return condition1;
	}

	public void setCondition1(String condition1) {
		this.condition1 = condition1;
	}

	public String getLiterature() {
		return literature;
	}

	public void setLiterature(String literature) {
		this.literature = literature;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getInit_date() {
		return init_date;
	}

	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}
	
	

}
