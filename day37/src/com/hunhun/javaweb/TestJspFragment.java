package com.hunhun.javaweb;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment bodyContent = getJspBody();
		
		//1.����StringWriter��ȡ��ǩ������
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		
		//2.תΪ��С
		String content = sw.toString().toUpperCase();
		
		//3.�����jsp�Ϳ���̨
		getJspContext().getOut().print(content);
		System.out.println(sw.toString());
	}
}
