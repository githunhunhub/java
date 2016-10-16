package com.hunhun.javaweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//Wrapper包装器模式(或叫：装饰器式Decorator)
public class MyHttpServletRequest extends HttpServletRequestWrapper{

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name) {
		String val = super.getParameter(name);
		if (val != null && val.contains(" fuck ")) {
			val = val.replace(" fuck ", " *** ");
		}
		return val;
	}
	
}
