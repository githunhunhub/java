<%@page import="com.hunhun.javaweb.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="customer" class="com.hunhun.javaweb.Customer" scope="request"></jsp:useBean>
	
	<jsp:setProperty property="name" name="customer"/>
	
	age: <jsp:getProperty property="age" name="customer"/>
	
	<%
		//Customer customer = (Customer)session.getAttribute("customer");
	%>
	
</body>
</html>