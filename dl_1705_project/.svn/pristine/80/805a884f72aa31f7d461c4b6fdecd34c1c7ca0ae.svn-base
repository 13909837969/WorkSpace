package com.qfjy.meeting.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfjy.meeting.bean.Users;
import com.qfjy.meeting.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	UsersService usersService;

	/**
	 * 微信端用户绑定流程 1、用户在微信端的登录页面中，输入邮箱 2、判断这个邮箱是否存在(Users)
	 * 如果不存在：提示邮箱不存在系统中（请联系管理员进行申请） 3、如果存在，用户绑定（wei_users)和Users中完成外键关联--》绑定成功
	 */
	@ResponseBody
	@RequestMapping("weixin/users_login") // weixin/users_login
	public String usersLogin(@RequestParam("email") String email,@RequestParam("openid")String openid) {
		// 1判断这个邮箱是否存在
		Users users = usersService.getByEmail(email);
		// 2如果不存在：
		if (users == null) {
			// 提示：您输入的邮箱在本系统中不存在（请联系管理员申请）
			 return "1";
		} else {// 3如果存在
				// 3.1判断该wid是否被绑定
			if (!StringUtils.isEmpty(users.getWid())) {
				// 3.2如果绑定 提示：您输入的邮箱已被人绑定，如果疑问，请尽快联系管理员
				  return "2";
			}else{
				// 3.3如果未被绑定，执行绑定功能。根据uid  修改Users中的wid
				//根据openid，查询wid
				String wid=usersService.getWidByOpenid(openid);
				usersService.updateUsersWidById(users.getId(), wid);
				return "3";	
			}
			
		}
		
	}
    //微信端 根据openid获得Users用户详情
	@RequestMapping("weixin/users_usersByOpenid")
	@ResponseBody
	public Users getUsersByOpenid(@RequestParam("openid")String openid){
		Users u=usersService.getByOpenid(openid);
		return u;
	}
	//微信端 根据ID修改个人信息
	@ResponseBody
	@RequestMapping("weixin/update_users")
	public String weixin_update_Users(Users u){
		int num=usersService.updateById(u);
		return ""+num;
	}
	@RequestMapping("users/users_add")
	public String users_add() {
		return "";
	}

}
