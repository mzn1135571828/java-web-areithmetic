<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<script type="text/javascript" src="ajax.js"></script>
	<script type="text/javascript">
		function login(){
			document.getElementById("register").style.display="none";
			document.getElementById("login").style.display="block";
			document.getElementById("log").style.background="rgba(100,100,100,.4)";
			document.getElementById("reg").style.background="rgba(51,51,51,.4)";
		}
		function register(){
			document.getElementById("login").style.display="none";
			document.getElementById("register").style.display="block";
			document.getElementById("reg").style.background="rgba(100,100,100,.4)";
			document.getElementById("log").style.background="rgba(51,51,51,.4)";
		}
		function formcheck(){
			var username = document.getElementById("username");
			var pwd1 =  document.getElementById("pwd1");
			var pwd2 =  document.getElementById("pwd2");
			var url = "Register";
			var params="username="+username.value+"&pwd1="+pwd1.value+"&pwd2="+pwd2.value;
			sendRequest(url,params,"POST",showresult);
		}
		function showresult(){
			if(xmlHttpRequest.readyState ==4){
				if(xmlHttpRequest.status == 200){
					var info = xmlHttpRequest.responseText;
					result.innerHTML=info;
				}
			}
		}
	</script>
  </head>
  
  <body>
  	<div class="box">
  		<div class="ahref"><a href="javascript:void(0)" onclick="login()" id="log">登录</a><a href="javascript:void(0)" onclick="register()" id="reg">注册</a></div>
	  	<div id="login">
	  	<h1>登录</h1>
	    <form action="Login" method="post">
	    	<input type="text" name="id" value="${requestScope.id}" placeholder="用户名" required="required"><br/>
	    	<input type="password" name="pwd" placeholder="密码" required="required"><br/>
	    	<button type="submit" class="btn btn-primary btn-block btn-large">登录</button><br/>
	    	<p>${requestScope.info}</p>
	    </form>
	   	</div>
	   	<div id="register" style="display:none;">
		   	<h1>注册</h1>
	    	<input type="text" name="username" id="username" placeholder="用户名" onblur="formcheck()" required="required"><br/>
	    	<input type="password" name="pwd1" id="pwd1" placeholder="密码" required="required"><br/>
	    	<input type="password" name="pwd2" id="pwd2" placeholder="再次输入密码" required="required"><br/>
	    	<button type="button" class="btn btn-primary btn-block btn-large" onclick="formcheck()">注册</button><br/>
	    	<div id="result"></div>
	   	</div>
	</div>
  </body>
</html>
