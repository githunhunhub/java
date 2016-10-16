package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.net.httpserver.Filter.Chain;
import com.sun.xml.internal.bind.v2.runtime.Name;

public class HelloFilter implements Filter {

	@Override
	//类似servlet的init，创建后即调用一次，且只有一次
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init...");
		System.out.println(config.getInitParameterNames());
		System.out.println(config.getInitParameter("name"));
	}

	@Override
	//拦截时调用此方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("1.doFilter...");
		
		chain.doFilter(request, response);
		
		System.out.println("2.chain.dofilter...");
	}

	@Override
	public void destroy() {
		System.out.println("destory");
		
	}

}
