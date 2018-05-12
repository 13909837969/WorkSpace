package com.qfjy.meeting.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="meetinggrab")
public class Meetinggrab 
{
	@Id
	private String id;
	private String gcompany;
	private String gremark;
	private Date currtDate;
	private String uid;
	private String pid;
	private int gstatus;
	private String gcurrtDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGcompany() {
		return gcompany;
	}
	public void setGcompany(String gcompany) {
		this.gcompany = gcompany;
	}
	public String getGremark() {
		return gremark;
	}
	public void setGremark(String gremark) {
		this.gremark = gremark;
	}
	public Date getCurrtDate() {
		return currtDate;
	}
	public void setCurrtDate(Date currtDate) {
		this.currtDate = currtDate;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getGstatus() {
		return gstatus;
	}
	public void setGstatus(int gstatus) {
		this.gstatus = gstatus;
	}
	public String getGcurrtDate() {
		return gcurrtDate;
	}
	public void setGcurrtDate(String gcurrtDate) {
		this.gcurrtDate = gcurrtDate;
	}
	public Meetinggrab() {
		super();
	}
	@Override
	public String toString() {
		return "meetinggrab [id=" + id + ", gcompany=" + gcompany + ", gremark=" + gremark + ", currtDate=" + currtDate
				+ ", uid=" + uid + ", pid=" + pid + ", gstatus=" + gstatus + ", gcurrtDate=" + gcurrtDate + "]";
	}
	
	

}
