
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date date = new Date();
		//System.out.print(date);
		
		String name = request.getParameter("name");
		System.out.println(name);
		
		System.out.println(response instanceof HttpServletResponse);
		
		ServletRequest req = pageContext.getRequest();
		System.out.println(req == request);
		
		System.out.println(session.getId());
		
		System.out.println(application.getInitParameter("password"));;
		
		System.out.println(config.getInitParameter("test"));
		
		out.println(this);
		
		out.println(page);
	%>
</body>
</html>