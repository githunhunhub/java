package com.hunhun.javaweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//Wrapper��װ��ģʽ(��У�װ����ʽDecorator)
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
