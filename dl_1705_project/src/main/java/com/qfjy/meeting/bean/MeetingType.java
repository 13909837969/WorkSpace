package com.qfjy.meeting.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class MeetingType {
	@Id
   private String id;
   private String tname;
   private Integer sortnum;
   private Integer status;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public Integer getSortnum() {
	return sortnum;
}
public void setSortnum(Integer sortnum) {
	this.sortnum = sortnum;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
   
   
   
   
}
