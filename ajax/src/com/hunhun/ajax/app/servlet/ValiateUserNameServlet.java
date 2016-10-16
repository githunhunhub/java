package com.hunhun.ajax.app.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValiateUserNameServlet
 */
public class ValiateUserNameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> userNames = Arrays.asList("AAA","BBB","CCC");
		
		String userName = request.getParameter("username");
		String result = null;
		if(userNames.contains(userName)){
			result = "<font color='red'>���û����Ѿ���ע��!</font>";
			
		}else {
			result = "<font color='green'>���û�������ʹ�ã�!</font>";
		}
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
