<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="../scripts/jquery-3.1.0.js"></script>
  <script type="text/javascript">
	$(function() {
		$("a").click(function() {
			//只加载h2
			var url = this.href + " h2";
			var args = {"time":new Date()};
			
			$("#details").load(url, args);
			
			return false;
		})
	})
  	  	  	
  </script>
  </head>
  
  <body>
    <h1>People</h1>
    <ul>
    	<li><a href="files/andy.html">Andy</a></li>
       	<li><a href="files/richard.html">Richard</a></li>
       	<li><a href="files/jeremy.html">Jeremy</a></li>
    </ul>
    <div id="details"></div>
  </body>
</html>
