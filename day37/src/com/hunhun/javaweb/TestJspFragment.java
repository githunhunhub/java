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
		
		//1.利用StringWriter获取标签体类容
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		
		//2.转为大小
		String content = sw.toString().toUpperCase();
		
		//3.输出的jsp和控制台
		getJspContext().getOut().print(content);
		System.out.println(sw.toString());
	}
}
