<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>BBBBBBB</h2>
	
	<%
		//请求转发,只能再当前WEB应用目录找，/代表当前   web应用   根目录
		//request.getRequestDispatcher("/c.jsp").forward(request, response);
		//request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
	
		//请求重定向，/表示当前    站点    根目录
		response.sendRedirect("c.jsp");
		//response.sendRedirect("http://www.baidu.com");
	%>

</body>
</html>