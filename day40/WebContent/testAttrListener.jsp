<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>Attribute Listener</h2>
	<span>ServletRequestAttribute的 <b>3</b> 种方法使用较少。</span>
	<%--
		request.setAttribute("name", "name");
	
		request.setAttribute("name", "name1");
		
		request.removeAttribute("name");
		
	--%>
	
	<p>HttpSession Listener <b>2</b> 种</p>
	
	<%--
		HttpSession session2 = request.getSession(true);
	
		session.invalidate();
		
	--%>
	
	<p>ServletContext Listener <b>3</b> 种</p>
	<%
	
	%>
</body>
</html>