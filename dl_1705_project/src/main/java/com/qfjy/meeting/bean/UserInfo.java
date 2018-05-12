package com.qfjy.meeting.bean;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

/**
  寰俊鐢ㄦ埛淇℃伅 鐢ㄦ潵瀛樺偍鐨勫璞�
 */
@Data
@Entity
@Table(name="wei_users")
public class UserInfo {
	@Id
	private String wid;
	private String openid;
	private String nickname;
	private String sex;
	private String city;
	private String country;
	private String language;
	private String headimgurl;
	private String subscribe;
	

	private String province;
	@Transient
	private long subscribe_time;
	@Transient
	private String remark;
	@Transient
	private Integer groupid;
	@Transient
	private String[] tagid_list;
	@Transient
	private String subscribe_scene;
	@Transient
	private String qr_scene;
	@Transient
	private String qr_scene_str;
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public long getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getGroupid() {
		return groupid;
	}
	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}
	public String[] getTagid_list() {
		return tagid_list;
	}
	public void setTagid_list(String[] tagid_list) {
		this.tagid_list = tagid_list;
	}
	public String getSubscribe_scene() {
		return subscribe_scene;
	}
	public void setSubscribe_scene(String subscribe_scene) {
		this.subscribe_scene = subscribe_scene;
	}
	public String getQr_scene() {
		return qr_scene;
	}
	public void setQr_scene(String qr_scene) {
		this.qr_scene = qr_scene;
	}
	public String getQr_scene_str() {
		return qr_scene_str;
	}
	public void setQr_scene_str(String qr_scene_str) {
		this.qr_scene_str = qr_scene_str;
	}
	public UserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfo [wid=" + wid + ", openid=" + openid + ", nickname=" + nickname + ", sex=" + sex + ", city="
				+ city + ", country=" + country + ", language=" + language + ", headimgurl=" + headimgurl
				+ ", subscribe=" + subscribe + ", province=" + province + ", subscribe_time=" + subscribe_time
				+ ", remark=" + remark + ", groupid=" + groupid + ", tagid_list=" + Arrays.toString(tagid_list)
				+ ", subscribe_scene=" + subscribe_scene + ", qr_scene=" + qr_scene + ", qr_scene_str=" + qr_scene_str
				+ "]";
	}
	
	
	
	
	
}
