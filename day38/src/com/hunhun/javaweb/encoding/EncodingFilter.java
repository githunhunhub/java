package com.hunhun.javaweb.encoding;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hunhun.javaweb.HttpFilter;

public class EncodingFilter extends HttpFilter{

	private String encoding;
	
	@Override
	//通过修改web.xml达到修改字符编码目的
	protected void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		
		filterChain.doFilter(request, response);
		
	}

}
