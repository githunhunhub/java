package com.hunhun.javaweb.test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class VisiterCount implements HttpSessionListener {

	private static int count = 0;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;

	}

}
