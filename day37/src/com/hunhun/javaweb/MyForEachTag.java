package com.hunhun.javaweb;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyForEachTag extends SimpleTagSupport{
	
	private String var;
	private Collection<?> items;
	
	
	
	public void setVar(String var) {
		this.var = var;
	}



	public void setItems(Collection<?> items) {
		this.items = items;
	}



	@Override
	public void doTag() throws JspException, IOException {
		if(items != null){
			for(Object obj : items){
				getJspContext().setAttribute(var, obj);
				
				getJspBody().invoke(null);
			}
		}
	}
}
