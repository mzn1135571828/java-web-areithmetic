 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="beans.Timu" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'subject.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/subject.css"/>
  </head>
  <body>
  <div id="mian">
		<div id="contain">
		    <form action="Result" method="post">
		    	<h2>题目:</h2>
		    	<span>${timu}</span><input type="text" name="result"><br/>
		    	<button type="submit" class="button">提交结果>></button>
		    </form>
    	</div>
	</div>
  </body>
</html>
