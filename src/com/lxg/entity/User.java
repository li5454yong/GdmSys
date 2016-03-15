package com.lxg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author lxg
 *
 * 2016年3月14日下午8:11:39
 */
@Entity
public class User {
	
	private int id;
	
	private String stu_num; //学号
	
	private String passwd;
	
	private Integer tid; //导师id
	
	private String tname; //导师姓名
	
	private String name; //姓名
	
	private String pic; //头像地址
	
	private int power; //权限
	
	private String haveMessage; //是否有未读消息

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getHaveMessage() {
		return haveMessage;
	}

	public void setHaveMessage(String haveMessage) {
		this.haveMessage = haveMessage;
	}

	
}
