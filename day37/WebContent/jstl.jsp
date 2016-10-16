<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.hunhun.javaweb.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>c:out</h3>
	<% 
		request.setAttribute("book", "<<Java>>");
	%>	
	<!-- 使用EL有时会出现转义错误，如此处的"<<java>>"，而JSTL可以避免-->	
	book: ${requestScope.book }
	<br>
	book: <c:out value="${requestScope.book }"></c:out>
	
	<hr>
	<h3>c:set</h3>
	<c:set var="name" value="hunhun" scope="page"></c:set>
	
	<%--
		pageContext.setAttribute("name", "hunhun");
	--%>
	name: ${pageScope.name }
	<br>
	
	<c:set var="sub" value="${param.sub }" scope="session"></c:set>
	sub: ${sessionScope.sub }
	<br>
	
	<%
		Customer customer = new Customer();
		customer.setId(0001);
		request.setAttribute("customer", customer);
	%>
	
	ID: ${requestScope.customer.id }
	<br>
	
	<c:set target="${requestScope.customer }" property="id" value="${param.id }"></c:set>
	ID: ${requestScope.customer.id }
	
	<hr>
	<h3>c:remove</h3>
	<c:set var="date" value="1995-4-8" scope="page"></c:set>
	date: *** ${pageScope.date } ***
	<br>
	<c:remove var="date" scope="page"/>
	after remove date: *** ${pageScope.date } *** 
	
	<hr>
	<h3>c:if ---- 没有else</h3>
	<c:set var="age" value="24" scope="request"></c:set>
	child/adult: <c:if test="${requestScope.age >= 18 }">adult</c:if>
	<br>
	
	但可以把if判断结果保存，并传递<br>
	<c:if test="${requestScope.age >= 18 }" var="isAdult" scope="request"></c:if>
	isAdult: <c:out value="${requestScope.isAdult }"></c:out>
	
	<hr>
	<h3>c:choose, c:when, c:otherwise ---可实现if--else</h3>
	child or adult: 
	<c:choose>
		<c:when test="${requestScope.age >= 18 }">adult</c:when>
		<c:when test="${requestScope.age < 18 }">child</c:when>
		<c:otherwise>can't find !</c:otherwise>
	</c:choose>
	
	<hr>
	<h3>c:foreach 遍历Array，Collection， Map</h3>
	<%
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(11, "AAA"));
		customers.add(new Customer(12, "BBB"));
		customers.add(new Customer(13, "CCC"));
		request.setAttribute("customers", customers);
		
		Map<String, Customer> custMap = new HashMap<String, Customer>();
		custMap.put("c", new Customer(13, "CCC"));
		custMap.put("a", new Customer(11, "AAA"));
		custMap.put("b", new Customer(12, "BBB"));
		request.setAttribute("custMap", custMap);
	%>
	Collection and Array<br>
	<c:forEach items="${requestScope.customers }" var="cust">
		${cust.id }: ${cust.name }
		<br>
	</c:forEach>
	
	Map<br>
	<c:forEach items="${requestScope.custMap }" var="custMap">
		${custMap.key }: ${custMap.value.id }, ${custMap.value.name }
		<br>
	</c:forEach>
	
	<hr>
	<h3>c:import 导入指定页面</h3>
	<h3>c:redirect 当前页面重定向的指定页面</h3>
	/ 代表web应用根目录
	
	<hr>
	<h3>c:url 配合重定向</h3>
	<c:url var="testurl" value="/test.jsp" scope="page">
		<c:param name="name" value="hunhun"></c:param>
	</c:url>
	url:${testurl }
	<br>
		
</body>
</html>