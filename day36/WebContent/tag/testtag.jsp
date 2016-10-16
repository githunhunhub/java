<%@page import="java.util.ArrayList"%>
<%@page import="com.hunhun.javaweb.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 利用标签写 -->
	<p>利用标签写</p>
	<c:forEach items="${requestScope.customers }" var="customer">
		${customer.id }
		${customer.name }
		${customer.age }
		<br>
	</c:forEach>
	
	<hr>
	
	<p>利用List直接遍历</p>
	<%
		List<Customer> customers = (List<Customer>)request.getAttribute("customers");
	
		if(customers != null){
			for(Customer customer : customers){
	%>
				<%= customer.getId()%>
				<%= customer.getName() %>
				<%= customer.getAge() %>
				<br>
	<%
			}
		}
	%>
	
</body>
</html>