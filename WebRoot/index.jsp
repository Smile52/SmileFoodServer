<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
  	function check_login()
  		{
  			if(document.loginFrom.username.value=""){
  				alert("用户名不能为空");
  				return false;
  			}
  			if(document.loginFrom.password.value=""){
  				alert("密码不能为空");
  				return false;
  			}
  		}
  </script>
  <body>
    <h2 align="center">食餐满堂管理系统</h2> <br>
   <h2 align="center">用户登录界</h2>
  <form action="servlet/LoginServlet" name="loginFrom" id="loginFrom" method="post" >
  	<table align="center">
  		<tr>
  			<td>用户名:</td>
  			<td><input type="text" name="username" value=""></td>
  		</tr>
  		<tr>
  			<td>密码：</td>	
  			<td><input type="password" name="password" value=""></td>
  			</tr>
  		<tr>
  			<td colspan="2" align="center"><input type="submit" value="登录"></td>
  		</tr>	
  	</table>
  </form>
    
    </form>
  </body>
</html>
