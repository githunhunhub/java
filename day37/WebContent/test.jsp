<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hunhun.javaweb.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="hun" uri="http://www.hunhun.com/mytag/core" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<hun:testJspFragment>Hello, 001.</hun:testJspFragment>
	<br><br>
	
	<hun:printUpper count="${param.count }">hunhun</hun:printUpper>
	
	<%
		List<Customer> customers = new ArrayList<Customer>();
	
		customers.add(new Customer(1, "AAA"));
		customers.add(new Customer(2, "BBB"));
		customers.add(new Customer(3, "CCC"));
		customers.add(new Customer(4, "DDD"));
		customers.add(new Customer(5, "EEE"));
		
		request.setAttribute("customers", customers);
		
		Map<String, Customer> cusMap = new HashMap<String, Customer>();
		cusMap.put("a", customers.get(0));
		cusMap.put("b", customers.get(1));
		cusMap.put("c", customers.get(2));
		cusMap.put("d", customers.get(3));
		cusMap.put("e", customers.get(4));
		request.setAttribute("cusMap", cusMap);
		
	%>
	
	<p>sun的forEach</p>
	<P>遍历List</P>
	<c:forEach items="${requestScope.customers }" var="cust">
		${cust.id } ---- ${cust.name }	<br>
	</c:forEach>
	<br>
	
	<p>遍历Map</p>
	<c:forEach items="${cusMap }" var="cus">
		${cus.key }: ${cus.value.id } ---- ${cus.value.name }	<br>
	</c:forEach>
	
	<p>重写的forEach</p>
	<p>遍历List</p>
	<hun:myForEach items="${requestScope.customers }" var="cust">
		${cust.id } ___ ${cust.name }	<br>
	</hun:myForEach>
	
	<p>遍历Map</p>
	......
	<br><br>
	
	<hun:parentTag>
		<hun:sunTag/>
	</hun:parentTag>
	<br>
	原版choose<br>
	<c:choose>
		<c:when test="${param.age >= 18}">已成年</c:when>
		<c:when test="${param.age < 18}">未成年</c:when>
		<c:otherwise>错误</c:otherwise>
	</c:choose>
	<br>
	重写的choose<br>
	<hun:chooseTag>
		<hun:whenTag test="${param.age >= 18}">已成年</hun:whenTag>
		<hun:whenTag test="${param.age < 18}">未成年</hun:whenTag>
		<hun:otherwiseTag>错误</hun:otherwiseTag>
	</hun:chooseTag>
	<br><br>
	
	<!-- 使用EL自定义函数 -->
	原版EL函数<br>
	${fn:length(param.name) }
	<br>
	自定义EL函数<br>
	${hun:concat(param.str1, param.str2) }
	
</body>
</html>