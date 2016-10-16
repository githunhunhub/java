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
		
		//��������url�б��˴�ֱ��д��ʵ��д�����ݿ���
		List<String> uncheckedUrls = Arrays.asList("/403.jsp", "/articles.jsp", 
				"/authorities.jsp", "/login.jsp", "/logout.jsp", 
				"/authority-manager.jsp", "/content.jsp", "/bbs.jsp");
		
		//���ʲ���Ҫ���˵���ַ
		if (uncheckedUrls.contains(servletPath)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		User user = (User)request.getSession().getAttribute("user");
		//System.out.println("***" + user);
		if (user == null) {//�ж��Ƿ��д��û�,û�����ض���
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		
		List<Authority> authorities = user.getAuthorities();
		
		//������ӦȨ�������
		Authority authority = new Authority(null, servletPath);
		
		//contains�����equals����������Authority��Ҫ��дequals
		if (authorities.contains(authority)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//û��Ȩ�ޣ��ض���
		response.sendRedirect(request.getContextPath() + "/403.jsp");
		return;
	}

   

}
