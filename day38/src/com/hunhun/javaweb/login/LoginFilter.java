package com.hunhun.javaweb.login;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hunhun.javaweb.HttpFilter;

public class LoginFilter extends HttpFilter{

	//1.��web.xml�л�ȡsessionKey�� redirect�� uncheckUrls
	private String redirectUrl;
	private String uncheckedUrls;
	private String sessionKey;
	
	@Override
	protected void init() {
		ServletContext servletContext = getFilterConfig().getServletContext();
		uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
		sessionKey = servletContext.getInitParameter("userSessionKey");
		redirectUrl = servletContext.getInitParameter("redirectUrl");
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//1.��ȡ����URL
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		String servletPath = request.getServletPath();
		
		//	http://localhost:8080/day38/login/a.jsp
		System.out.println(requestUrl);
		//	/day38/login/a.jsp
		System.out.println(requestUri);
		//	/login/a.jsp
		System.out.println(servletPath);
		
		//2.����ȡ��servletPath���Ƿ�����web.xml�в���������
		List<String> urls = Arrays.asList(uncheckedUrls.split(","));
		if(urls.contains(servletPath)){
			filterChain.doFilter(request, response);
			return;
		}
		
		//3.��session�л�ȡsessionKey���ж��Ƿ����㣬�������ض���
		Object user = request.getSession().getAttribute(sessionKey);
		if(user == null){
			response.sendRedirect(request.getContextPath() + redirectUrl);
			System.out.println(request.getContextPath());
			return;
		}
		
		//4.���������
		filterChain.doFilter(request, response);
		
	}

}
