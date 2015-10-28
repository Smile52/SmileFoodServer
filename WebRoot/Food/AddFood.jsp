<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddFood.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h2>添加菜页面</h2>
    <div>
    <form action="servlet/AddFoodServlet" method="post" enctype="multipart/form-data">
    <li>菜名：<input type="text" name="foodname"></li>
    <li>价格：<input type="text" name="foodprice"></li>
    <li>描述：<input  type="text" name="fooddetail"></li>
    <li>图片：<input type="file" name="foodimg" ></li>
    <input type="submit" value="提交">
    </form>
    </div>
  </body>
</html>
