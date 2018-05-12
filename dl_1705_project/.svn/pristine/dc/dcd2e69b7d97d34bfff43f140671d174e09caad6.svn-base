package com.qfjy.meeting.commoms.mail;



import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
		//smtp.qq.com      smtp.sina.com   smtp.sohu.com  smtp.163.com
	    private final static String smtpHost = "smtp.qq.com";//配置Email session对象
	    private final static String messageType = "text/html;charset=UTF-8";//相应内容类型，编码类型
	    private final static String subject = "用户邮箱注册激活认证";//主题
	    private final static String fromEmail = "315759265@qq.com";//发送邮件的邮箱
	    private final static String password = "";//密码(口令)

	    @SuppressWarnings("static-access")
	    public static boolean sendMessage(String to) {
	        try {
	        	//邮件的内容
	            String messageText ="您好，欢迎来注册电子商务网站。请点击连接激活 ...."
	            		+ "http://127.0.0.1:8080/shop/aa.jsp?id=asfdsafdsaf"
	            		+ "你好，这是一封测试邮件。收到请勿回复 </br>"
	    	     		+ " <H3 align='center'>微信登录</H3><div align='center'><br />"
	            		
	    	     		+ "<img src='https://www.baidu.com/img/bd_logo1.png?where=super' /> <br />"
	    	     		+ "请使用微信扫描二维码登录'公众平台测试账号系统'</div>";
	            //第一步：配置javax.mail.Session对象   mail.properties
	            Properties props = new Properties();   // 创建Properties 类用于记录邮箱的一些属性
	            props.put("mail.smtp.host", smtpHost);  //此处填写SMTP服务器
	            props.put("mail.smtp.starttls.enable", "true");//使用 STARTTLS安全连接
	            props.put("mail.smtp.port", "25");             //google使用465或587端口
	            props.put("mail.smtp.auth", "true");       // 表示SMTP发送邮件，必须进行身份验证
	            props.put("mail.debug", "true");
	            Session mailSession = Session.getInstance(props, new MyAuthenticator(fromEmail, password));//此处填写你的账号和口令(16位口令)

	            //第二步：编写消息
	            InternetAddress fromAddress = new InternetAddress(fromEmail);// 设置发件人的邮箱
	            InternetAddress toAddress = new InternetAddress(to); // 设置收件人的邮箱
	            MimeMessage message = new MimeMessage(mailSession);
	            message.setFrom(fromAddress);
	            message.addRecipient(RecipientType.TO, toAddress);
	            message.setSentDate(Calendar.getInstance().getTime());
	            message.setSubject(subject);   // 设置邮件标题
	            message.setContent(messageText, messageType);// 设置邮件的内容体

	            // 第三步：发送消息
	            Transport transport = mailSession.getTransport("smtp");
	            transport.connect(smtpHost, fromEmail, password);
	            transport.send(message, message.getRecipients(RecipientType.TO)); // 发送邮件啦

	            return true;
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        
	            return false;
	        } catch (Exception e) {
	         
	            return false;
	        }
	    }
	    
	    public static void main(String[] args) {
			/*
			 * 测试邮件发送
			 * 1、加入mail.jar
			 * 2.直接发邮件
			 */
	    
	    	String to="2819945690@qq.com";
	    	
	    		boolean b=SendEmail.sendMessage(to);
	    		if(b){
		    		System.out.println("邮件发送已成功");
		    	}else{
		    		System.out.println("邮件发送失败--");
		    	}
	    	
	    	
	    }

}
