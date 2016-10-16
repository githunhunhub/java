<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Login Page</h3>
	<font color="red">${message }</font>
	<br><br>
	
	<form action="hello.jsp" method="post">
	
		usernane: <input type="text" name="username" value="${param.username }">
		<br><br>
		password: <input type="text" name="password" value="">
		<br>
		<input type="submit" value="Submit">
		
	</form>

</body>
</html>