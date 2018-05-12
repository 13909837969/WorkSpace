package com.qfjy.meeting.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfjy.meeting.bean.UserInfo;
import com.qfjy.meeting.dao.UserInfoRepository;
import com.qfjy.meeting.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
@Autowired
	UserInfoRepository userInfoRepository;
	@Override
	public UserInfo getByOpenid(String openid) {
		// TODO Auto-generated method stub
		return userInfoRepository.getByOpenid(openid);
	}
	@Override
	public void add(UserInfo u) {
		u.setWid(UUID.randomUUID().toString());
		userInfoRepository.save(u);
	}
	
}
