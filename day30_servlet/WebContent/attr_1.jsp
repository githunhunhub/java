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
		pageContext.setAttribute("pageContextAttr", "pageContextVal");
		request.setAttribute("requestAttr", "requestVal");
		session.setAttribute("sessionAttr", "sessionVal");
		application.setAttribute("applicationAttr", "applicationVal");
	%>
	<h2>Attr 1 Page: <%= new Date() %></h2>
	<br>
	
	pageContextValue: <%= pageContext.getAttribute("pageContextAttr") %>
	<br>
	
	requestValue: <%= request.getAttribute("requestAttr") %>
	<br>
	
	sessionValue: <%= session.getAttribute("sessionAttr") %>
	<br>
	
	applicationValue: <%= application.getAttribute("applicationAttr") %>
	<br>
	
	<a href="attr_2.jsp">Jump to Attr2 Page</a>
	<br>
	
	<a href="testAttr">To Attr Servlet</a>
	
	<%
		request.getRequestDispatcher("/attr_2.jsp").forward(request, response);
	%>
	
</body>
</html>