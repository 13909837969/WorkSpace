package com.qfjy.weixin.api.accessToken;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听器（整个项目）
 * @author My
 * applaction (整个项目应用）
 *
 */
public class AccessTokenListener implements ServletContextListener  {


	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("#############项目上启动了~~~");
		//线程启动
		new AccessTokenThread().start();
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
