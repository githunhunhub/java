package com.hunhun.javaweb;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintUpper extends SimpleTagSupport{
	
	private String count;
	
	public void setCount(String count) {
		this.count = count;
	}
	

	@Override
	public void doTag() throws JspException, IOException {
		
		//1.�õ���ǩ������
		JspFragment bodyContent = getJspBody();		
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		String content = sw.toString();
		
		//2.תΪ��д
		content = content.toUpperCase();
		
		//3.���count �ε�jspҳ��
		int a = 0;
		try {
			a = Integer.parseInt(count);
		} catch (NumberFormatException e) {
			getJspContext().getOut().print("count�д���" + "<br>");
			
		}
		
		for(int i = 0; i < a; i++){
			getJspContext().getOut().print(content + "<br>");
		}
		
	}
}
