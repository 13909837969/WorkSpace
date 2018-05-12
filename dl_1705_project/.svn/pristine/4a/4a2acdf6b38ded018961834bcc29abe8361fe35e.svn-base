package com.qfjy.meeting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfjy.meeting.bean.LoginUsers;
import com.qfjy.meeting.dao.LoginUsersRepository;
import com.qfjy.meeting.service.LoginUsersService;

@Service
public class LoginUsersServiceImpl implements LoginUsersService {
   @Autowired
	LoginUsersRepository loginUsersRepository;
	
	@Override
	public LoginUsers getByUsername(String uname) {
		// TODO Auto-generated method stub
		return loginUsersRepository.getByUsername(uname);
	}
	
	
}
