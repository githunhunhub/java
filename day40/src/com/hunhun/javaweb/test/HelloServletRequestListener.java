package com.hunhun.javaweb.test;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class HelloServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("ServletRequestListener Ïú»Ù..." + arg0.getServletRequest());

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("ServletRequestListener ³õÊ¼»¯..." + arg0.getServletRequest());

	}

}
