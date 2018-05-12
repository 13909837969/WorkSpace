package com.qfjy.meeting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qfjy.meeting.bean.UserInfo;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
	//根据openid查询 对象数据
	public UserInfo getByOpenid(String openid);
}
