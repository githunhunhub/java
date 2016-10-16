<%@page import="com.hunhun.javaweb.mvc.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table.grid {
		border: 1px solid;
		border-collapse: collapse;
	}
	table.grid th{
		border: 1px solid;
		background-color: #ceb6b6;
	}
	table.grid td{
		border: 1px solid;
		background-color: #ffffff;
	}
</style>
</head>
<body>

	<%
		List<Student> stus = (List<Student>)request.getAttribute("students");
	%>

	<table class="grid">

		<tr>
			<th>Flow_id</th>
			<th>Type</th>
			<th>Id_card</th>
			<th>Exam_card</th>
			<th>Name</th>
			<th>Location</th>
			<th>Grade</th>
			<th>Delete</th>
		</tr>

		<%
			for(Student student: stus){
		%>
			<tr>
				<td><%=student.getFlowId()%></td>
				<td><%=student.getType()%></td>
				<td><%=student.getIdCard()%></td>
				<td><%=student.getExamCard()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getLocation()%></td>
				<td><%=student.getGrade()%></td>
				<td><a href="deletStudent?flowId=<%= student.getFlowId()%>">Delete</a></td>
			</tr>
		<%
			}
		%>

	</table>

</body>
</html>