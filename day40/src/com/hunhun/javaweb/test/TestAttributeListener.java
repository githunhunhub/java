package com.hunhun.javaweb.test;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class TestAttributeListener
		implements ServletContextAttributeListener, ServletRequestAttributeListener, HttpSessionActivationListener {

	/**
	 * ServletContext Listener	3ÖÖ
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("ServletContext attributeAdded");

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("ServletContext attributeRemoved");

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("ServletContext attributeReplaced");

	}

	/**
	 * ServletRequest Listener	3ÖÖ
	 */

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("attributeAdded");

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("attributeRemoved");

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("attributeReplaced");

	}

	/**
	 * HttpSession Listener	2ÖÖ
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("sessionDidActivate");

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("sessionWillPassivate");
	}

}
