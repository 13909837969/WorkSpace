package com.qfjy.meeting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.qfjy.meeting.bean.LoginUsers;

public interface LoginUsersRepository extends JpaRepository<LoginUsers,String> {

	//方法定义规范
	public LoginUsers getByUsername(String uname);
	
	@Query(value="delete from LoginUsers where id=?",nativeQuery=true)
	@Modifying //executeUpdate
	@Transactional
	public int deleteId(String id);
	
	
}
