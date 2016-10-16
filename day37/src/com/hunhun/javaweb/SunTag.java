package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SunTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		
		//1.�ӱ�ǩ��ȡ����ǩ,���ڲ�֪���ӱ�ǩʱ��ͨTag
		//����SimpleTag��������תΪJspTag����ǿתΪParentTag
		JspTag parent = getParent();
		
		//2.��JspTagǿתΪParentTag
		ParentTag parentTag = (ParentTag)parent;
		String name = parentTag.getName();
		
		getJspContext().getOut().print(name);
		
	}
}
