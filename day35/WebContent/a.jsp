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
	<h3>A Page</h3>
	
	<a href="b.jsp">To B Page</a>
	<br><br>
	<%
		session.setAttribute("time", new Date());
	%>
	CurrentTime: <%= new Date() %>
	<br><br>
	SessionTime: <%= session.getAttribute("time") %>
</body>
</html>