package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�������������û��ظ��ύ���������������ѹ��
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//�жϱ���Ƿ�һ��
		HttpSession session = request.getSession();
		
		Object token = session.getAttribute("token");
		String tokenVal = request.getParameter("token");
		
		if(token != null && token.equals(tokenVal)){
			session.removeAttribute("token");
		}else {
			response.sendRedirect(request.getContextPath() + "/token/token.jsp");
			return;
		}
		
		
		String name = request.getParameter("name");
		
		System.out.println("name: " + name);
		
		//request.getRequestDispatcher("/token/success.jsp").forward(request, response);
		
		response.sendRedirect(request.getContextPath() + "/token/success.jsp");
	}

}
