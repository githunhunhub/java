<%@page import="com.hunhun.mvcapp.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Object msg = request.getAttribute("message");%>
	<p><font color="red"><%= request.getAttribute("message") == null ? "" : msg %></font></p>
	
	<%
		String id = null;
		String oldName = null;
		String name = null;
		String phone = null;
		String address = null;
		
		Customer customer = (Customer)request.getAttribute("customer");
		if(customer != null){
			id = customer.getId() + "";
			oldName = customer.getName();
			name = customer.getName();
			address = customer.getAddress();
			phone = customer.getPhone();
		}else{
			id = request.getParameter("id");
			oldName = request.getParameter("oldName");
			name = request.getParameter("oldName");
			address = request.getParameter("address");
			phone = request.getParameter("phone");
		}
	%>
	<form action="update.do" method="post">
	<!--  在修改时id要固定，所以利用隐藏域的方式-->
		<input type="hidden" name="id" value="<%= id%>">
		<!-- 利用隐藏域保留原始值，避免查找数据库时查找自己（此方法为通用方法） -->
		<input type="hidden" name="oldName" value="<%= oldName%>">
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name"
					value="<%=name%>"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"
					value="<%= address%>"></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"
					value="<%= phone%>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit Edit"></td>
			</tr>
		</table>

	</form>
</body>
</html>