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
			String tokenVal = new Date().getTime() + "";
			session.setAttribute("token", tokenVal);
		%>
	<form action="<%= request.getContextPath() %>/tokenServlet" method="post">
		
		<input type="hidden" name="token" value="<%= tokenVal%>">
		name: <input type="text" name="name">
		<br><br>
		<input type="submit" value="Submit">
		
	</form>
</body>
</html>