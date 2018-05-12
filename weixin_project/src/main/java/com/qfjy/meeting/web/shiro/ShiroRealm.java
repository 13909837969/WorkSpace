package com.qfjy.meeting.web.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.qfjy.meeting.bean.LoginUsers;
import com.qfjy.meeting.service.LoginUsersService;



public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	LoginUsersService loginUsersService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1token转换成UsernamePasswordToken
				UsernamePasswordToken upToken=(UsernamePasswordToken) token;
			 	//upToken.getPassword();
				//2获得用户名
				String uname=upToken.getUsername();
				//3根据用户名查询数据库
				LoginUsers users=loginUsersService.getByUsername(uname);
				//未认证帐户异常
				if(users==null){
					//抛出异常 未认证帐户异常（用户名错误）
					throw new UnknownAccountException("用户名输入错误");
				}
				//帐户锁定异常
				if(1==users.getStatus()){
					throw new LockedAccountException("帐户被锁定异常");
				}
				   
				/**
				 	身份验证：一般需要提供如身份 ID 等一些标识信息来表明登录者的身份，如提供 email，用户名/密码来证明。
			在 shiro 中，用户需要提供 principals （身份）和 credentials（证  明）给 shiro，从而应用能验证用户身份：
		•	principals：身份，即主体的标识属性，可以是任何属性，如用户名、  邮箱等，唯一即可。一个主体可以有多个 principals，但只有一个  Primary principals，一般是用户名/邮箱/手机号。
		•	credentials：证明/凭证，即只有主体知道的安全值，如密码/数字证  书等。
			最常见的 principals 和 credentials 组合就是用户名/密码了 
				 */
				Object principal=uname;
				Object hashedCredentials=users.getPassword();//数据库中查询的密码
				String realmName=super.getName();
				ByteSource credentialsSalt=ByteSource.Util.bytes(uname);//盐值加密
				//密码的比对 是由Shiro完成
				
				SimpleAuthenticationInfo info=
					//	new SimpleAuthenticationInfo(principal, credentials,realmName );
					new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
				return info;

	}
	
	public static void main(String[] args) {
		/*
		 * 模拟后台用户注册数据，(123,将字符串按加密规则生成加密数据，将期 添加到数据库中用户表中的密码数据
		 */
		String hashAlgorithmName="MD5"; //加密名称
		Object credentials="123"; //需要加密的字符串
		int hashIterations=1705; //加密的次数
		String uname="admin";
		Object salt=ByteSource.Util.bytes(uname);//盐值加密
		Object obj=new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(obj);
	}
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}



}
