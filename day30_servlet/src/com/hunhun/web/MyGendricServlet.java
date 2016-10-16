package com.hunhun.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class MyGendricServlet implements Servlet, ServletConfig {
	
	@Override
	public void destroy(){}

	@Override
	public ServletConfig getServletConfig() {
		
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	private ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.servletConfig = arg0;
		init();
		
	}
	
	public void init() throws ServletException{};

	//抽象方法，必须实现，没有方法体
	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1) 
			throws ServletException, IOException;

	
	//一下为ServletConfig接口方法
	@Override
	public String getInitParameter(String arg0) {
		// TODO Auto-generated method stub
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration getInitParameterNames() {
		// TODO Auto-generated method stub
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return servletConfig.getServletName();
	}

}
