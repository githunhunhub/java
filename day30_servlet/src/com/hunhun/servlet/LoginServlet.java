package com.hunhun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.hunhun.web.MyGendricServlet;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends MyGendricServlet {
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		super.init(arg0);
	}
	
	/*@Override
	//不建议覆盖带参数的init(ServletConfig ),否则容易出现空指针异常
	public void init() throws ServletException {
		System.out.println("初始化。。。");
	};*/

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println("***-- " + user + ": " + password);

		String contextUser = getServletContext().getInitParameter("user");
		String contextPassword = getServletContext().getInitParameter("password");
		System.out.println(contextUser + ": " + contextPassword);

		PrintWriter writer = response.getWriter();
		if (user.equals(contextUser) && password.equals(contextPassword)) {
			writer.println("They are the same.");
		} else {
			writer.print("They are different.");
		}

	}

}
