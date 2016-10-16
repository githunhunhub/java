package com.hunhun.javaweb;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class UsernameFilter implements Filter {

    public UsernameFilter() {
    	
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String initeuser = filterConfig.getInitParameter("username");
		String username = request.getParameter("username");
		
		if (!initeuser.equals(username)) {
			request.setAttribute("message", "username is wrong!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	private FilterConfig filterConfig;
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
