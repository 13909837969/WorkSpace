package com.qfjy.meeting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfjy.meeting.bean.Users;
import com.qfjy.meeting.dao.UsersRepository;
import com.qfjy.meeting.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
	UsersRepository usersRepository;
	@Override
	public Users getByOpenid(String openid) {
		// TODO Auto-generated method stub
		return usersRepository.getByOpenid(openid);
	}

}
