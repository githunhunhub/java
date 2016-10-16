<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a:VISITED {
	color: blue;
	}
</style>
</head>
<body>
	<!-- 显示最近浏览的5本书，并要排序：把最后浏览的放在最后。 -->

	<h3>Books Page</h3>
	
	<a href="book.jsp?book=JavaWeb">JavaWeb</a><br><br>
	<a href="book.jsp?book=Java">Java</a><br><br>
	<a href="book.jsp?book=Oracle">Oracle</a><br><br>
	<a href="book.jsp?book=JavaScript">JavaScript</a><br><br>
	<a href="book.jsp?book=JQuery">JQuery</a><br><br>
	<a href="book.jsp?book=Ajax">Ajax</a><br><br>
	<a href="book.jsp?book=Android">Android</a><br><br>
	<a href="book.jsp?book=Jbpm">Jbpm</a><br><br>
	<a href="book.jsp?book=Struts">Struts</a><br><br>
	<a href="book.jsp?book=Spring">Spring</a><br><br>
	
	<hr><hr>
	
	<%
	Cookie[] cookies = request.getCookies();
	
	if(cookies !=null && cookies.length > 0){
		for(Cookie c:cookies){
			String cookieName = c.getName();
			if(cookieName.startsWith("hunhun_book_")){
				out.print(c.getValue());
				out.print("&nbsp");
			}
		}
	}
	%>
	<br>
	<br>
	<br>
	<br>
</body>
</html>