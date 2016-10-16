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
	 * ���л�����ԴӴ����϶�ȡ�洢��session
	 */
	private static final long serialVersionUID = 1L;

	//���ּ������ֱ������application�� request��session
	//ServletContext��ã�һ����webӦ������ʱ�������ݿ�Ƚ��г�ʼ�������������
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//System.out.println("Servlet ����..." + arg0.getServletContext());

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//System.out.println("Servlet ��ʼ��..." + arg0.getServletContext());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//System.out.println("Request ����..." + arg0.getServletRequest());

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		//System.out.println("Request ��ʼ��..." + arg0.getServletRequest());

	}
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//System.out.println("Session ����..." + arg0.getSession());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		//System.out.println("Session ����..." + arg0.getSession());
		
	}
}
