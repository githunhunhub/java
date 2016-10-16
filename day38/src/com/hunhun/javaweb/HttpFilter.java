package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义HttpFilter，类似自定义HttpServlet
 * @author nerve
 *
 */
public abstract class HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		doFilter(request, response, chain);

	}
	
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws IOException, ServletException;

	
	private FilterConfig filterConfig;
	/**
	 * 不建议子类直接覆盖
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}
	
	protected void init() {}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	@Override
	public void destroy() {}
}
