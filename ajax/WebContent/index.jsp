<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

	window.onload = function() {
		//获取 a 并取消默认行为
		document.getElementsByTagName("a")[0].onclick = function() {
			
			//创建XMLHttpRequest()
			var request = new XMLHttpRequest();
			
			//创建请求url, 添加时间戳可禁用缓存
			var url = this.href + "?time=" + new Date();
			
			//创建请求方法：post， get
			var method = "GET";
			//var method = "POST";
			
			//建立请求
			request.open(method, url);
			
			//发送请求
			request.send(null);
			//request.send("name = 'hunhun'");
			
			request.onreadystatechange = function () {
				if (request.readyState == 4) {	//4 表示响应完成
					if(request.status == 200 || request.status == 304){
						alert(request.responseText);
					}
				}
			}
			
			return false;
		}
	}

</script>
</head>
<body>
	<a href="helloAjax.txt">Hello, world!</a>
</body>
</html>