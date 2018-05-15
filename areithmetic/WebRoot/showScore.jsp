<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="dao.ScoreDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showScore.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/result.css"/>
  </head>
  
  <body>
    <%
    	int score = Integer.parseInt(session.getAttribute("count").toString());
    	session.setAttribute("count", 0);
     %>
    <div id="mian">
			<div id="contain">
			    <h2>挑战结束</h2>
			    <p>本次得分：<span class="ans" style="color: red;"><%=score %></span>分</p>
			    <a href="main.jsp" class="button">返回主菜单</a>
    		</div>
		</div>
	</body>
</html>
