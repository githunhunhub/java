<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="../scripts/jquery-3.1.0.js"></script>
  <script type="text/javascript">
  	
  $(function() {
		$("a").click(function() {
			var url = this.href;
			var args = {"time":new Date()};
			
			//此处可以选择get和post方法
			$.getJSON(url, args, function(data) {
				var name = data.person.name;
				var website = data.person.website;
				var email = data.person.email;
				
				$("#details").empty()
							 .append("<h2><a href='"+ email +"'>"+name+"</a></h2>")
							 .append("<a href='"+website+"'>"+website+"</a>");
				
			});			 
				

			
			return false;
		});
	})
  	  	  	
  </script>
  </head>
  
  <body>
    <h1>People</h1>
    <ul>
    	<li><a href="files/andy.js">Andy</a></li>
       	<li><a href="files/richard.js">Richard</a></li>
       	<li><a href="files/jeremy.js">Jeremy</a></li>
    </ul>
    <div id="details"></div>
  </body>
</html>
