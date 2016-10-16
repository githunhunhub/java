<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	<h4>Error hello!!!</h4>
	 -->
	 
	 <!-- 需要转码，否则会乱码 ,或者在TomCat中的server.xml添加
	 useBodyEncodingForURI="true"属性,下面的request只对POST请求
	 有效，要想对Get有效，需要配置server.xml	-->
	 
	<% request.setCharacterEncoding("UTF-8"); %>	
	
	Hello Username1： <%= request.getParameter("username") %>
	
</body>
</html>