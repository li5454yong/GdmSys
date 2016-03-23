package com.lxg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 毕业设计
 * @author 李新广
 *
 * 2016年3月18日下午2:24:03
 */
@Entity
public class GraduationProject {

	private int id;
	
	private int sid;
	
	private int isHave; //是否有毕业设计  0-有  1-没有
	
	private String dataPath;
	
	private Date init_date;
	
	private String fileName;
	
	private int status;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsHave() {
		return isHave;
	}

	public void setIsHave(int isHave) {
		this.isHave = isHave;
	}

	public String getDataPath() {
		return dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

	public Date getInit_date() {
		return init_date;
	}

	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
