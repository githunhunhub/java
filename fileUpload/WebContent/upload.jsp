<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Upload Page...</h2>
	
	上传的表单：form action="UploadServlet" method="post" enctype="multipart/form-data"。<br>
		enctype="multipart/form-data"表示以二进制格式编码传输
	<br><br>
	
	<form action="uploadServlet" method="post" enctype="multipart/form-data">
		File: <input type="file" name="file">
		<br><br>
		Desc: <input type="text" name="desc">
		<br><br>
		<input type="submit" value="Submit">
	</form>

</body>
</html>