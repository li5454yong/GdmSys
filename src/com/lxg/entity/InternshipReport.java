package com.lxg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 实习报告
 * @author 李新广
 *
 * 2016年3月18日下午2:14:43
 */
@Entity
public class InternshipReport {

	private int id;
	
	private int sid;
	
	private String qyds; //企业导师
	
	private String zw; //导师职务
	
	private String xl; //学历
	
	private String dszy; //导师专业
	
	private String email; //导师邮箱
	
	private String phonenum; //导师电话
	
	private String dwemail; //企业邮箱
	
	private String dwphone;//单位电话
	
	private String dwsf;//单位省份
	
	private String dwmc; //单位名称
	
	private String dwdz; //单位地址
	
	private String sxnr;//实习内容
	
	private String sxzj; //实习总结
	
	private String picture; //上传图片地址
	
	private int status; //审核状态

	
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

	public String getQyds() {
		return qyds;
	}

	public void setQyds(String qyds) {
		this.qyds = qyds;
	}

	public String getZw() {
		return zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public String getDszy() {
		return dszy;
	}

	public void setDszy(String dszy) {
		this.dszy = dszy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getDwemail() {
		return dwemail;
	}

	public void setDwemail(String dwemail) {
		this.dwemail = dwemail;
	}

	public String getDwphone() {
		return dwphone;
	}

	public void setDwphone(String dwphone) {
		this.dwphone = dwphone;
	}

	public String getDwsf() {
		return dwsf;
	}

	public void setDwsf(String dwsf) {
		this.dwsf = dwsf;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getDwdz() {
		return dwdz;
	}

	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}

	public String getSxnr() {
		return sxnr;
	}

	public void setSxnr(String sxnr) {
		this.sxnr = sxnr;
	}

	public String getSxzj() {
		return sxzj;
	}

	public void setSxzj(String sxzj) {
		this.sxzj = sxzj;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
