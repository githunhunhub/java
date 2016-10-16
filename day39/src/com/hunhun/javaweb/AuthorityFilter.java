package com.hunhun.javaweb;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthorityFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		String servletPath = request.getServletPath();
		
		//不需拦截url列表，此处直接写，实际写在数据库中
		List<String> uncheckedUrls = Arrays.asList("/403.jsp", "/articles.jsp", 
				"/authorities.jsp", "/login.jsp", "/logout.jsp", 
				"/authority-manager.jsp", "/content.jsp", "/bbs.jsp");
		
		//访问不需要过滤的网址
		if (uncheckedUrls.contains(servletPath)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		User user = (User)request.getSession().getAttribute("user");
		//System.out.println("***" + user);
		if (user == null) {//判断是否有此用户,没有则重定向
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		
		List<Authority> authorities = user.getAuthorities();
		
		//包含对应权限则访问
		Authority authority = new Authority(null, servletPath);
		
		//contains会调用equals方法，所以Authority中要重写equals
		if (authorities.contains(authority)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//没有权限，重定向
		response.sendRedirect(request.getContextPath() + "/403.jsp");
		return;
	}

   

}
