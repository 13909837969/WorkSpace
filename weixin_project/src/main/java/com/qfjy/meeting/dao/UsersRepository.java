package com.qfjy.meeting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qfjy.meeting.bean.Users;
public interface UsersRepository extends JpaRepository<Users,String> {
	//根据openid，查询Users表中数据是否存在(验证微信用户是否进行数据绑定（登录）)
	
	@Query(value=" select * from users where wid=(select wid from wei_users where openid=?)"
			,nativeQuery=true)
	public Users getByOpenid(String openid);
}
