package com.qfjy.weixin.api.accessToken;

import org.springframework.util.SystemPropertyUtils;

import com.qfjy.weixin.main.MenuManager;
import com.qfjy.weixin.pojo.AccessToken;
import com.qfjy.weixin.util.WeixinUtil;

import net.sf.json.JSONObject;

/**
 * 1、access_token的存储至少要保留512个字符空间
 * 2、access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。 
 * 3、每日接口只能调用2000次。
 */

public class AccessTokenThread extends Thread {
	public static String access_token;
	public void run() {
		 while(true){
			 // 1000=1秒  2小时=  1000*60*60*2
			 try {
				Thread.sleep(1000*60*60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //调用生成access_token
			AccessToken at=getAccessToken(MenuManager.appId,MenuManager.appSecret);
			access_token=at.getToken();
			
		 }
	}
	
	
	/**
	  调用微信服务器，生成access_token 
	 */
	private static String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		System.out.println("获取凭证："+jsonObject.toString());
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
				
			//	System.out.println(accessToken.getExpiresIn());
			} catch (Exception e) {
				accessToken = null;
				e.printStackTrace();
				// 获取token失败
			}
		}
		return accessToken;
	}
}
