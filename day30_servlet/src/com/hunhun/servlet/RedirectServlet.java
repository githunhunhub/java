package com.hunhun.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RedirectServlet doGet...");
		
		request.setAttribute("name", "12345...");
		System.out.println("RedirectServlet name: " + request.getAttribute("name"));
		
		String path = "testServlet";
		response.sendRedirect(path);
	}

}
