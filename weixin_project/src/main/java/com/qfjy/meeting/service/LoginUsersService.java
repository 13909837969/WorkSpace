package com.qfjy.meeting.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qfjy.meeting.bean.LoginUsers;

public interface LoginUsersService {
	//Shiro登录功能  根据用户名，查询 
	public LoginUsers getByUsername(String uname);
	//查询所有的登录用户数据
	public List<LoginUsers> getAll();
	//删除

	public int deleteById(String id);
	//添加
	public void add(LoginUsers loginUsers);
}
