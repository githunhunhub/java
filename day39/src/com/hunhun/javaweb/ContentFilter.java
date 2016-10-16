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
//		//使用自定义的req.getParameter()方法
		HttpServletRequest req = new MyHttpServletRequest(request);
		
		req.setCharacterEncoding("utf-8");
//		
//		if (content.contains(" fuck ")) {
//			//由于HttpServletRequest中没有setParameter(paramName, paramValue)的方法
//			//所以要修改getParameter(String)方法来实现
//			
//		}
		
		filterChain.doFilter(req, response);
	}


}
