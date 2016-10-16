package com.hunhun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hunhun.web.MyHttpServlet;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet2 extends MyHttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String method = request.getMethod();
		System.out.println(method);
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");
		
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(initUser.equals(username) && initPassword.equals(password)){
			writer.println("hello: " + username);
		}else {
			writer.println("Sorry: " + username);
		}
	}

}
