<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage="WEB-INF/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date date = new Date();
		DateFormat dateFormat = null;
	%>
	<%
		//int i = 10/0;
	%>
	
	<form action="hello.jsp" method="get">
		<!-- 默认传输过程中编码为 ISO-8859-1 -->
	
		Username:<input type="text" name="username">
		
		<input type="submit" value="submit">
	
	</form>
</body>
</html>