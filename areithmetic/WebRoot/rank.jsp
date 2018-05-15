<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="beans.Score" %>
<%@ page import="dao.ScoreDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rank.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/rank.css"/>
	<style type="text/css">
		#all_me{
			color:red;
		}
	</style>
	<script type="text/javascript">
			function show_me(){
				document.getElementById("all").style.display="none";
				document.getElementById("me").style.display="block";
				document.getElementById("click_me").style.backgroundColor="#C9C9C9";
				document.getElementById("click_all").style.backgroundColor="#3B3B3B";
			}
			function show_all(){
				document.getElementById("me").style.display="none";
				document.getElementById("all").style.display="block";
				document.getElementById("click_all").style.backgroundColor="#C9C9C9";
				document.getElementById("click_me").style.backgroundColor="#3B3B3B";
			}
	</script>
  </head>
  
  <body>
  	<%
  		String id = session.getAttribute("id").toString();
  		List<Score> rank_all = (List<Score>)session.getAttribute("rank_all");
  		List<Score> rank_me = (List<Score>)session.getAttribute("rank_me");
  		int i=0,j=0;
  	 %>
    	<div id="mian">
			<div id="contain">
			    <h2>排行榜</h2>
		    	<div class="rank">
		    		<p>
			    		<a href="javascript:void(0)" onclick="show_me()" id="click_me">个人排行</a>
			    		<a href="javascript:void(0)" onclick="show_all()" id="click_all">世界排行</a>
		    		</p>
		    		<div id="me">
		    			<table border="0" width="200px">
		    				<thead>
		    					<tr><td>排行</td><td>得分</td></tr>
		    				</thead>
		    				<tbody>
		    					<% for(Score sco:rank_me){ 
		    						i++;%>
		    						<tr><td><%=i %></td><td><%=sco.getScore() %></td></tr>
		    					<%} %>	
		    				</tbody>
		    			</table>
		    		</div>
		    		<div id="all" style="display:none;">
		    			<table border="0" width="300px">
		    				<thead>
		    					<tr><td>排行</td><td>玩家</td><td>得分</td></tr>
		    				</thead>
		    				<tbody>
		    					<% for(Score sco:rank_all){ 
		    						j++;
		    						if(id.equals(sco.getId())){%>
		    						<tr id="all_me"><td><%=j %></td><td><%=sco.getId() %></td><td><%=sco.getScore() %></td></tr>
		    						<%}else{ %>
		    						<tr><td><%=j %></td><td><%=sco.getId() %></td><td><%=sco.getScore() %></td></tr>
		    						<%} %>
		    					<%} %>	
		    				</tbody>
		    			</table>
		    		</div>
		    	</div>
		    	<a href="main.jsp" class="button">返回</a>
    		</div>
		</div>
  </body>
</html>
