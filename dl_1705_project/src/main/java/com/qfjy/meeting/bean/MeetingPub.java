package com.qfjy.meeting.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class MeetingPub {
   @Id
   private String id;
   private String pcode;
   private String ptime;
   private String tid;
   private String ptitle;
   private String pcompany;
   private String pzone;
   private String uid;
   private Integer status;
   private Date currtDate;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPcode() {
	return pcode;
}
public void setPcode(String pcode) {
	this.pcode = pcode;
}
public String getPtime() {
	return ptime;
}
public void setPtime(String ptime) {
	this.ptime = ptime;
}
public String getTid() {
	return tid;
}
public void setTid(String tid) {
	this.tid = tid;
}
public String getPtitle() {
	return ptitle;
}
public void setPtitle(String ptitle) {
	this.ptitle = ptitle;
}
public String getPcompany() {
	return pcompany;
}
public void setPcompany(String pcompany) {
	this.pcompany = pcompany;
}
public String getPzone() {
	return pzone;
}
public void setPzone(String pzone) {
	this.pzone = pzone;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Date getCurrtDate() {
	return currtDate;
}
public void setCurrtDate(Date currtDate) {
	this.currtDate = currtDate;
}
   
   
   
   
}
