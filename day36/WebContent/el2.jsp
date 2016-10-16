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

	age: ${sessionScope.customer.age }
	<br>
	
	<%
		Customer customer = new Customer();
		customer.setName("hunhun");
		
		session.setAttribute("com.hunhun.web", customer);
	%>
	
	<!-- 当有"."时使用[]号 -->
	name: ${sessionScope["com.hunhun.web"].name }
	
</body>
</html>