package com.hunhun.javaweb.test;

import java.io.Serializable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HelloServeltContextListener implements ServletContextListener, 
	ServletRequestListener, HttpSessionListener, Serializable {

	/**
	 * 序列化后可以从磁盘上读取存储的session
	 */
	private static final long serialVersionUID = 1L;

	//三种监听器分别监听：application， request，session
	//ServletContext最常用，一般再web应用启动时，对数据库等进行初始化，生命周期最长
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//System.out.println("Servlet 销毁..." + arg0.getServletContext());

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//System.out.println("Servlet 初始化..." + arg0.getServletContext());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//System.out.println("Request 销毁..." + arg0.getServletRequest());

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		//System.out.println("Request 初始化..." + arg0.getServletRequest());

	}
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//System.out.println("Session 创建..." + arg0.getSession());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		//System.out.println("Session 销毁..." + arg0.getSession());
		
	}
}
