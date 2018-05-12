package com.company.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.dao.pojo.Info;
import com.company.service.iservice.InfoService;

import junit.framework.TestCase;

public class InfoDaoTest extends TestCase
{

	public void testGetById() 
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("spring_core.xml");
		InfoService is = act.getBean(InfoService.class);
		Info info = is.getById(2);
		System.out.println(info);
	
	}

}
