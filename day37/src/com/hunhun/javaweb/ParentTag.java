package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParentTag extends SimpleTagSupport{
	
	private String name = "hunhun";
	
	public String getName() {
		return name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("ParentTag: " + name);
		getJspBody().invoke(null);
	}
}
