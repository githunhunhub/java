package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SunTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		
		//1.子标签获取父标签,由于不知道子标签时普通Tag
		//还是SimpleTag，所以先转为JspTag，再强转为ParentTag
		JspTag parent = getParent();
		
		//2.把JspTag强转为ParentTag
		ParentTag parentTag = (ParentTag)parent;
		String name = parentTag.getName();
		
		getJspContext().getOut().print(name);
		
	}
}
