package com.hunhun.javaweb.test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HelloHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//System.out.println("Session ����..." + arg0.getSession());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		//System.out.println("Session ����..." + arg0.getSession());
		
	}


}
