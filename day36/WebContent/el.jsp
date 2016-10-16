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

	<form action="el.jsp" method="post">
		
		username: <input type="text" name="username">
		<br><br>
		
		<!-- 利用EL语法回显 -->
		username: <input type="text" name="username" 
					value="${param.username }">
		<br><br>
		
		<input type="submit" value="Submit">
		
	</form>
	
		username: <%= request.getParameter("username") == null ? "" : request.getParameter("username")%>
	<br><br>
	
	<jsp:useBean id="customer" class="com.hunhun.javaweb.Customer" scope="session"></jsp:useBean>
	<jsp:setProperty property="age" value="18" name="customer"/>
	
	age:<%
		Customer customer2 = (Customer) session.getAttribute("customer");
		out.print(customer2.getAge());
		%>
	<br>
	
	age: <jsp:getProperty property="age" name="customer"/>
	<br>
	
	<a href="el2.jsp">To el2.jsp Page</a>
	
	
	
	
</body>
</html>