package com.qfjy.meeting.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qfjy.meeting.web.utils.ValidateColorServlet;

@Controller
@RequestMapping("loginUsers")
public class LoginUsersController {
     
	
	//登录
	@RequestMapping("login")   // loginUsers/login
	public ModelAndView login(
			@RequestParam("username")String uname,
			@RequestParam("password")String upass,
			@RequestParam("loginCode")String codeLogin,HttpSession session){
		ModelAndView model=new ModelAndView();
	     model.setViewName("redirect:/pages/admin/succ.jsp");
		
	     //验证码验证
	     /**
	      * 1、用户输入的验证码 loginCode
	      * 2、通过服务器生成图片的验证码字符串：
	      *    通过Session CHECK_CODE_KEY获取验证码字符串
	      */
	    String codeServer=(String) session.getAttribute(ValidateColorServlet.CHECK_CODE_KEY);
	    if(!codeServer.equalsIgnoreCase(codeLogin)){//验证码不区分大小写
	    		//验证码输入错误
        	model.addObject("loginMsg","验证码输入错误");
        	model.setViewName("/pages/admin/login.jsp");
        	return model;
	    }
	    
	    
	     
		 //获得当前执行（登录）用户
        Subject currentUser = SecurityUtils.getSubject();
        // 是否进行登录（认证）
        if (!currentUser.isAuthenticated()) {
        	//前端用户输入： 用户名 ,密码
            UsernamePasswordToken token = new UsernamePasswordToken(uname,upass);
            //记住我
            token.setRememberMe(true);
            try {
            	//执行登录功能
                currentUser.login(token);
              
            }
            //未认证帐户异常（用户名错误）
            catch (UnknownAccountException uae) {
            	System.out.println("用户名输入错误---"+token.getPrincipal());
            	model.addObject("loginMsg","用户名输入错误");
            	model.addObject("username",uname);
            	model.addObject("password",upass);
            	model.setViewName("/pages/admin/login.jsp");
            } 
            //密码凭证异常（密码错误）
            catch (IncorrectCredentialsException ice) {
            	System.out.println("密码输入错误---"+token.getPrincipal());
            	model.addObject("loginMsg","密码输入错误");
            	model.addObject("username",uname);
            	model.addObject("password",upass);
            	model.setViewName("/pages/admin/login.jsp");
            } 
            //帐户锁定异常
            catch (LockedAccountException lae) {
            	System.out.println("帐户锁定异常---");
            	model.addObject("loginMsg","因异常，您的帐户已被锁定，暂无法登录");
            	model.setViewName("/pages/admin/login.jsp");
            }
            //认证（登录）异常
            catch (AuthenticationException ae) {
            	System.out.println("用户名或密码错误");
            	model.setViewName("/pages/admin/login.jsp");
            }
        }
   
		return model;
	}
}