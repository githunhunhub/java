<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 给客户端写入一个Cookie：cookiePath  -->
	<%
	
		Cookie cookie = new Cookie("cookiePath", "pathValue");
	
		//设置cookie作用范围
		cookie.setPath(request.getContextPath());
		//out.print(request.getContextPath());	// /day34
		
		response.addCookie(cookie);
	
	%>
	
	<a href="../cookie2.jsp">To Read Cookie</a>
</body>
</html>