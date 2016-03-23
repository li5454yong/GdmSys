package com.lxg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 毕业论文
 * @author 李新广
 *
 * 2016年3月18日下午3:08:23
 */
@Entity
public class Thesis {

	private int id;
	
	private int sid; //学生id
	
	private String title; //论文题目
	
	private String etitle; //英文题目
	
	private String gjz; //关键字
	
	private String egjz; //英文关键字
	
	private String zy; //摘要
	
	private String ezy; //英文摘要
	
	private String path; //上传文件的路径
	
	private String fileName;
	
	private Date init_date; //进表日期
	
	private String dsyj; //导师意见

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEtitle() {
		return etitle;
	}

	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}

	public String getGjz() {
		return gjz;
	}

	public void setGjz(String gjz) {
		this.gjz = gjz;
	}

	public String getEgjz() {
		return egjz;
	}

	public void setEgjz(String egjz) {
		this.egjz = egjz;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getEzy() {
		return ezy;
	}

	public void setEzy(String ezy) {
		this.ezy = ezy;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getInit_date() {
		return init_date;
	}

	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}

	public String getDsyj() {
		return dsyj;
	}

	public void setDsyj(String dsyj) {
		this.dsyj = dsyj;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}
