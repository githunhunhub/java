package com.hunhun.javaweb.test;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class HelloServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("ServletRequestListener ����..." + arg0.getServletRequest());

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("ServletRequestListener ��ʼ��..." + arg0.getServletRequest());

	}

}
