<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//	Java中Cookie类代表cookie	
		//1.cookie创建
		//Cookie cookie = new Cookie("name","hunhun");
		//2.调用response的一个方法把cookie传给客户端
		//response.addCookie(cookie);
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie : cookies){
				out.print(cookie.getName() + " : " + cookie.getValue());
				out.print("<br><br>");
			}
		}else{
			out.print("<h3>no cooke !!!<h3>");
			
			Cookie cookie = new Cookie("name", "hunhun");
			//设置cookie存活时间,单位s，为0表示立即删除，为负数，表示不存储cookie
			cookie.setMaxAge(30);
			
			response.addCookie(cookie);
		}
	%>

</body>
</html>