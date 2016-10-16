<%@page import="com.hunhun.javaweb.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>请确认相关信息：</h3>
	<form action="" method="post">
		<%
			Customer customer = (Customer)session.getAttribute("customer");
			String[] books = (String[])session.getAttribute("books");
		%>
		<table border="1" cellpadding="10" cellspacing="0">

			<tr>
				<td>姓名</td>
				<td><%= customer.getName() %></td>
			</tr>
			
			<tr>
				<td>地址</td>
				<td><%= customer.getAddress() %></td>
			</tr>
			
			<tr>
				<td>卡类型</td>
				<td><%= customer.getCardType() %></td>
			</tr>
			
			<tr>
				<td>卡号</td>
				<td><%= customer.getCard() %></td>
			</tr>
			
			<tr>
				<td>您选择的书：</td>
				<td>
					<%
					for(String book : books){
						out.print(book);
						out.print("&nbsp");
					}
					%>
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>