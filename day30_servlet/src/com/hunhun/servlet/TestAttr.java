package com.hunhun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TestAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		Object requestValue = request.getAttribute("requestAttr");
		out.println("requestAttr: " + requestValue);
		out.println();
		
		Object sessionValue = request.getSession().getAttribute("sessionAttr");
		out.println("sessionAttr: " + sessionValue);
		out.println();
		
		Object applicationValue = getServletContext().getAttribute("applicationAttr");
		out.println("applicationAttr: " + applicationValue);
	}

}
