<%@page import="java.util.Date"%>
<%@page import="com.hunhun.javaweb.test.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>HttpSessionBinding Listener</h2>
	<%--
		Customer customer = new Customer();
		session.setAttribute("customer", customer);
		
		System.out.println("--------------------");
		
		session.removeAttribute("customer");
	--%>
	
	<%
		Customer customer = (Customer)session.getAttribute("customer");
		if(customer == null){
			System.out.println("创建Customer对象，"+ customer +"+并放入session种。");
			customer = new Customer();
			customer.setTime("" + new Date());
			session.setAttribute("customer", customer);
		}else{
			System.out.println("从session中读取的customer：" + customer);
		}
	%>
	
</body>
</html>