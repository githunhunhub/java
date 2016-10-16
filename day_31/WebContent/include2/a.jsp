<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Include AAA Page</h2>
	
	<!-- 静态引入 -->
	<%--
	<jsp:include page="b.jsp"></jsp:include>
	 --%>
	 
	 <!-- jsp:forward,jsp:inclued可以传入参数，利用jsp:param -->
	 <jsp:forward page="b.jsp">
	 	<jsp:param value="abcde" name="username"/>
	 </jsp:forward>
</body>
</html>