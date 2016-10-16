package com.hunhun.javaweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckCodeServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
		System.out.println(paramCode);
		
		String sessionCode = (String) request.getSession().getAttribute("CHECK_CODE_KEY");
		System.out.println(sessionCode);
		
		//判断验证码是否相同，忽略大小写
		//如果不一致
		if(!(paramCode != null && paramCode.equalsIgnoreCase(sessionCode))){
			request.getSession().setAttribute("message", "验证码错误！！");
			System.out.println("验证码错误");
			response.sendRedirect(request.getContextPath() + "/check/index.jsp");
			return;
		}
		
		System.out.println("请求已经受理。");
	}

}
