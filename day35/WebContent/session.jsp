<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<!-- session="false" 表示当前页面不允许隐含session变量，但可以使用显式的session-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpSession session = request.getSession(true);
		out.print(session.getId() + "<br>");
		
		session.setMaxInactiveInterval(500);
		out.print(session.getMaxInactiveInterval()); //default value is 1800(s).
		
		session.invalidate();
	%>
</body>
</html>