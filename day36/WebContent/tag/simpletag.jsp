<%@page import="java.util.ArrayList"%>
<%@page import="com.hunhun.javaweb.Customer"%>
<%@page import="java.util.List"%>
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
		List<Customer> customers = new ArrayList<Customer>();
	
		customers.add(new Customer(1, "AAA", 18));
		customers.add(new Customer(2, "BBB", 19));
		customers.add(new Customer(3, "CCC", 20));
		customers.add(new Customer(4, "DDD", 14));
		customers.add(new Customer(5, "EEE", 15));
		
		request.setAttribute("customers", customers);
	%>
	
	<!-- 遍历显示customer -->
	<jsp:forward page="testtag.jsp"></jsp:forward>
	
</body>
</html>