<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	content:<br>
	<!--  request.getParameter("content")  
		由于获得value是通过getParameter,所以需要重写此方法以达到过滤目的
	-->
	${param.content }
	
	<br><br>
	<%= request %><br><br>
	<a href="content.jsp">To content.</a>
</body>
</html>