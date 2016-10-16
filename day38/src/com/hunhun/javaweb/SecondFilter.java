package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("destory2222");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("3.doFilter2222");
		
		chain.doFilter(request, response);
		
		System.out.println("4.chain.doFilter222");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init222");
		
	}


}
