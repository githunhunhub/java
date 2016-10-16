package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ContentFilter
 */
public class ContentFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
//		String content = request.getParameter("content");
//		//ʹ���Զ����req.getParameter()����
		HttpServletRequest req = new MyHttpServletRequest(request);
		
		req.setCharacterEncoding("utf-8");
//		
//		if (content.contains(" fuck ")) {
//			//����HttpServletRequest��û��setParameter(paramName, paramValue)�ķ���
//			//����Ҫ�޸�getParameter(String)������ʵ��
//			
//		}
		
		filterChain.doFilter(req, response);
	}


}
