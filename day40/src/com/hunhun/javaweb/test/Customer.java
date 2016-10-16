package com.hunhun.javaweb.test;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer 
	implements HttpSessionBindingListener, 
				HttpSessionActivationListener{

	private String time;

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("�󶨵� session...");

		Object obj = event.getValue();
		System.out.println("*" + obj);
		System.out.println("**" + (obj == this));
		System.out.println("***" + event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.err.println("�� session �����...");

	}

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("�Ӵ����ж�ȡ...");
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("�洢��������...");
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return super.toString() + " time: " + time;
	}
}
