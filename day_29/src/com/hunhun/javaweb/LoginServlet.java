package com.hunhun.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	// service用于应答请求
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		// System.out.println("comeing...");
		// System.out.println(request);

		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println("user= " + user + "\n" + "password= " + password);

		String interesting = request.getParameter("interesting");
		System.out.println(interesting);

		String[] interestings = request.getParameterValues("interesting");
		for (String interest : interestings) {
			System.out.println("***" + interest);
		}

		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println("---" + name);
		}

		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			System.out.println("Map--  " + entry.getKey() + ": " + Arrays.asList(entry.getValue()));
		}

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		String requestURI = httpServletRequest.getRequestURI();
		StringBuffer requestURL = httpServletRequest.getRequestURL();
		System.out.println("requestURL--- " + requestURL);
		System.out.println("requestURI--- " + requestURI);

		String method = httpServletRequest.getMethod();
		System.out.println("method: " + method);

		// get 方法
		String queryString = httpServletRequest.getQueryString();
		System.out.println("queryString--- " + queryString);

		String servlerPath = httpServletRequest.getServletPath();
		System.out.println("servlerPath--- " + servlerPath);
		
		response.setContentType("application/msword");

		PrintWriter out = response.getWriter();
		out.println("helloworld...");
	}

}
