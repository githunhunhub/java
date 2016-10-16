<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	SessionID: <%= session.getId() %>
	<br><br>
	
	IsNew: <%= session.isNew() %>
	<br><br>
	
	MaxInactiveInterval: <%= session.getMaxInactiveInterval() %>
	<br><br>
	
	CreateTime: <%= session.getCreationTime() %>
	<br><br>
	
	LastAccessTime: <%= session.getLastAccessedTime() %>
	<br><br>
	
	Hello: <%= request.getParameter("username") %>
	<br><br>
	
	<%
		session.setAttribute("username", request.getParameter("username")); 
	%>
	<a href="<%= response.encodeURL("login.jsp")%>">Return to Login Page.</a>
	&nbsp;&nbsp;&nbsp;
	<a href="<%= response.encodeURL("logout.jsp")%>">Logout</a>
</body>
</html>