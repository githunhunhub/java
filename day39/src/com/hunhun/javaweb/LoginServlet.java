package com.hunhun.javaweb;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName = request.getParameter("method");
		
		try {
			Method method = getClass().getMethod(methodName, 
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private UserDao userDao = new UserDao();
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//��login.jspҳ���ȡ�û�����name
		String name = request.getParameter("name");
		//System.out.println("##" + name);
		
		//����UserDao��get�������ж�users��Map���Ƿ���keyΪname��Map��
		//���ж���û�д��û�����������name�����Ҳ���ǲ��䣬û�еĻ�
		//��User֧��null�򷵻�null
		User user = userDao.get(name);
		//System.out.println("###" + user);
		
		request.getSession().setAttribute("user", user);
		
		response.sendRedirect(request.getContextPath() + "/articles.jsp");
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		request.getSession().invalidate();
		
		response.sendRedirect(request.getContextPath() + "/logout.jsp");
	}

}
