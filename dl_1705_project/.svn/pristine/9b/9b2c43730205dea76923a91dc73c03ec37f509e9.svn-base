package com.qfjy.weixin.api.userInfo;

import org.springframework.stereotype.Service;

import com.qfjy.weixin.util.WeixinUtil;

import net.sf.json.JSONObject;
@Service
public class UserInfoServiceApi {
	
	/**  注意：考虑代码的复用性。
	 * 
	   用户关注公众时，（收集用户个人信息）
	   1、先判断用户是否在我数据库中存在
	                   如果数据存在：（更新，什么都不做）
	          如果数据不存在：添加到数据库中。
	                 
	 */
	
	
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
