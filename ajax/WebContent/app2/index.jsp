<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.1.0.js"></script>
<script type="text/javascript">

	$(function() {
		
		$("a").click(function() {
			var url = this.href;
			var args = {"time":new Date()};
			
			$.getJSON(url, args, function(data) {
				$("#bookName").text(data.bookName);
				$("#totalBookNumber").text(data.totalBookNumber);
				$("#totalMoney").text(data.totalMoney);
			})
			
			return false;
		});
		
		
	})

</script>
</head>
<body>
	您已经将&nbsp; <span id="bookName"></span>&nbsp;加入购物车，
	共计&nbsp; <span id="totalBookNumber"></span>&nbsp;本书，
	总计 &nbsp; <span id="totalMoney"></span>&nbsp;元。
	
	《Java》<a href="addToCart?id=Java&price=100">加入购物车</a>
	<br><br>
	
	《Oracle》<a href="addToCart?id=Oracle&price=200">加入购物车</a>
	<br><br>
	
	《Struts2》<a href="addToCart?id=Struts2&price=100">加入购物车</a>

</body>
</html>