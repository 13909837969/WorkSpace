package com.qfjy.weixin.api.userInfo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfjy.meeting.bean.UserInfo;
import com.qfjy.meeting.service.UserInfoService;
import com.qfjy.weixin.util.WeixinUtil;

import net.sf.json.JSONObject;
@Service
public class UserInfoServiceApi {
	@Autowired
	UserInfoService userInfoService;
	
	/**  注意：考虑代码的复用性。
	 * 
	   用户关注公众时，（收集用户个人信息）
	       先判断用户是否在我数据库中存在
	                   如果数据存在：（更新，什么都不做）
	          如果数据不存在：添加到数据库中。    
	 */
	public void userInfoService(String access_token,String openid){
		//1判断用户信息是否存在数据库
		UserInfo userInfo=this.getByOpenid(openid);
		if(userInfo!=null){
			//1.1如果存在情况下
			System.out.println("用户数据已存在:"+openid);
		}else{
			//1.2收集用户个人信息
			JSONObject json=getUserInfoAPI(access_token,openid);
			//1.3将JSON对象转成UserInfo对象
			UserInfo ui=this.jsonConverObj(json);
			//1.4添加到数据库
			userInfoService.add(ui);
		}
	}
	

	
	//将JSON对象转成UserInfo对象
	public UserInfo jsonConverObj(JSONObject json){
		ObjectMapper mapper=new ObjectMapper();
		UserInfo userInfo=null;
		try {
			 userInfo=mapper.readValue(json.toString(),UserInfo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
	
	//根据openid查询该用户的信息是否在数据库wei_users
	public UserInfo getByOpenid(String openid){		
		return userInfoService.getByOpenid(openid);
	}
	
	private static String api_userInfo_url=" https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	/**
	 * 获取用户基本信息（包括UnionID机制）
	 */
	public JSONObject getUserInfoAPI(String access_token,String openid){
		String userinfo_url=api_userInfo_url.replace("ACCESS_TOKEN",access_token).replace("OPENID", openid);
		JSONObject json=WeixinUtil.httpRequest(userinfo_url, "GET", null);
		return json;
	}
}
