<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- 导入标签库(描述文件) --> 
<%@ taglib uri="http://www.hunhun.com/mytag/core" prefix="hun"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hun:hello value="${param.name }"  count="10"/>
	<br>
	<hun:Max num2="${param.num2 }" num1="${param.num1 }"/>
	<br>
	<hun:readFile src="/WEB-INF/01.txt"/>
</body>
</html>