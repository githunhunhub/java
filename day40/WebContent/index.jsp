<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	
	<h2>Index Page</h2>
	<a href="test.jsp">To test page...</a>
	<br><br>
	<%--
		request.setAttribute("reqKey", "reqVal");
	--%>
	
	<a href="TestServlet">请求转发是一个Request，而重定向是两个</a>
	<br><br>
	
	<%
		HttpSession session1 = request.getSession(true);
		session1.setMaxInactiveInterval(5);
	%>
	<a href="session.jsp">To session.jsp</a>
	<br><br>
	
	
</body>
</html>