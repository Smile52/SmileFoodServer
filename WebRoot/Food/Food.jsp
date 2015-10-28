<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Food.jsp' starting page</title>
    
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
    <h2 align="center">菜单管理</h2> 
    <a href="http://localhost:8080/SmileFoodServer/Food/AddFood.jsp">添加菜</a> &nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/SmileFoodServer/Food/DeleteFood.jsp">删除菜</a>
    <div>
    	<table width="80%" border="1">
    	<tbody>
    		<tr>
    			<th width="10%">序号</th>
    			<th>菜名</th>
    			<th>价格</th>
    			<th>描述</th>
    			<th>图片链接</th>
    			<th width="20%">预定数量</th>
    		</tr>
    		<c:forEach items="${objlist}" var="food" >
    			<tr >
    				<td>${obj[0]} </td>
    				<td>${obj[1]}</td>
    				<td>${obj[2]}</td>
    				<td>${obj[3]}</td>
    				<td>${obj[4]}</td>
    				<td>${obj[5]}</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    	</table>
    </div>
  
  </body>
</html>
