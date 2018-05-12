package com.qfjy.meeting.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfjy.meeting.bean.LoginUsers;
import com.qfjy.meeting.dao.LoginUsersRepository;
import com.qfjy.meeting.service.LoginUsersService;

@Service
public class LoginUsersServiceImpl implements LoginUsersService {
   @PersistenceContext
	EntityManager em;
	@Autowired
	LoginUsersRepository loginUsersRepository;
	
	@Override
	public LoginUsers getByUsername(String uname) {
		// TODO Auto-generated method stub
		return loginUsersRepository.getByUsername(uname);
	}
	//查询所有的登录用户数据
	public List<LoginUsers> getAll(){
		return loginUsersRepository.findAll();
	}
	//删除  executeUpdate

	public int deleteById(String id){

		return loginUsersRepository.deleteId(id);

	}
	public void add(LoginUsers loginUsers){
		loginUsers.setId(UUID.randomUUID().toString());
		loginUsers.setLastCurrtDate(new Date());
		loginUsers.setStatus(2);//0有效， 1无效，2邮箱未激活
		String pwd=loginUsers.getPassword();//明文密码
		//加密密码
		loginUsers.setPassword(pwdAlgorithmName(pwd,loginUsers.getUsername()));
		
		loginUsersRepository.save(loginUsers);
	}
	
	//根据加密规则，对字符进行加密，常用于密码加密功能
	public String pwdAlgorithmName(String upass,String uname){
		String hashAlgorithmName="MD5"; //加密名称
		Object credentials=upass; //需要加密的字符串
		int hashIterations=1705; //加密的次数
		Object salt=ByteSource.Util.bytes(uname);//盐值加密
		Object obj=new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		return obj.toString();
	}
	
}
