package com.qfjy.meeting.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class LoginUsers {
	@Id
	private String id;
	private String username;
	private String password;
	private Date lastCurrtDate;
	private String lastIp;
	private String uid;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastCurrtDate() {
		return lastCurrtDate;
	}
	public void setLastCurrtDate(Date lastCurrtDate) {
		this.lastCurrtDate = lastCurrtDate;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LoginUsers() {
		super();
	}
	@Override
	public String toString() {
		return "LoginUsers [id=" + id + ", username=" + username + ", password=" + password + ", lastCurrtDate="
				+ lastCurrtDate + ", lastIp=" + lastIp + ", uid=" + uid + ", status=" + status + "]";
	}
	
	
}
