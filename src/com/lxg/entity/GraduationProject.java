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
	
	private int isHave;
	
	private String dataPath;
	
	private Date init_date;

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
	
	

}
