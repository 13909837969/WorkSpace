package com.qfjy.meeting.web.weixin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qfjy.meeting.bean.Users;
import com.qfjy.meeting.service.UsersService;
import com.qfjy.weixin.main.MenuManager;
import com.qfjy.weixin.util.WeixinUtil;

import net.sf.json.JSONObject;

@RequestMapping("weixin")
@Controller
public class WeixinController {
	@Autowired
	UsersService usersService;
	 
	/**
	 * OAuth2.0认证
	 * @throws IOException 
	 */
	@RequestMapping("oatuth/isLogin")
	public void oAtuthIsLogin(HttpServletResponse response) throws IOException{
		String redirect_uri=MenuManager.REAL_URL+"weixin/isLogin";
		//授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
		 try {
			 redirect_uri=URLEncoder.encode(redirect_uri,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//1 第一步：用户同意授权，获取code
		String url="https://open.weixin.qq.com/connect/oauth2/authorize?"
				+ "appid="+MenuManager.appId
				+ "&redirect_uri="+redirect_uri
				+ "&response_type=code"
				+ "&scope=snsapi_base"
				+ "&state=Java1705#wechat_redirect";
		response.sendRedirect(url);
	}
	
	
	/**
	  微信端操作:
	    验证当前微信用户是否进行了绑定，
	    如果没有绑定，则跳到登录页面
	   如果绑定，则跳到目标页面
	 */
	@RequestMapping(value="isLogin")  // http://weixinguo.s1.natapp.cc/dl_1705_project/weixin/isLogin
	public String isLogin(@RequestParam("code")String code,@RequestParam("state")String state){
		//第二步：通过code换取网页授权access_token
		System.out.println(code);
		System.out.println(state);
		//第三步：code换取网页授权access_token
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?"
				+ "appid="+MenuManager.appId
				+ "&secret="+MenuManager.appSecret
				+ "&code="+code
				+ "&grant_type=authorization_code";
		JSONObject json=WeixinUtil.httpRequest(url,"POST", null);
		System.out.println(json.toString());
		//第四步验证当前微信用户是否进行了绑定
		 //通过openid得到wid (wei_users)  ,查询users根据wid查询	
		String openid=json.getString("openid");
		Users users=usersService.getByOpenid(openid);
		//4.1如果绑定，跳到目标页面
		if(users!=null){
			return "redirect:/pages/weixin/users/users_view.jsp?openid="+openid;
		}
		//4.2如果未绑定，跳到登录页面
		return "/pages/weixin/login.jsp";
	}
}
