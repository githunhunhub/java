<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	SessionID: <%= session.getId() %>
	<br><br>
	
	IsNew: <%= session.isNew() %>
	<br><br>
	
	MaxInactiveInterval: <%= session.getMaxInactiveInterval() %>
	<br><br>
	
	CreateTime: <%= session.getCreationTime() %>
	<br><br>
	
	LastAccessTime: <%= session.getLastAccessedTime() %>
	<br><br>
	
	<%
		Object username = session.getAttribute("username");
		if(username == null){
			username = "";
		}
	%>
	<!-- response.encodeURL("login.jsp") 在cookie被禁用时使用，以保持会话-->
	<!-- 它表示URL重写，当cookie被禁用时，会在URL后添加“ ;jsessionid=D5BA95....”以保持session -->
	<form action="<%= response.encodeURL("hello.jsp")%>" method="post">
	
	
		username: <input type="text" name="username" value="<%= username%>">
		<br><br>
		<input type="submit" value="Submit">
		
	</form>
	
</body>
</html>