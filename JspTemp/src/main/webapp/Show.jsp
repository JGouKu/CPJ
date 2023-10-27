<%@page import="Servlet.shop" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>已添加商品</title>
	</head>
	<body>
<%--			<%--%>
<%--				shop s = (shop)request.getAttribute("shop");--%>
<%--			%>--%>
<%--			<%=s.getName()%>--%>
		<jsp:useBean id="Shop" type="Servlet.shop" scope="request"/>
		<jsp:getProperty name="Shop" property="name"/><br>
		<jsp:getProperty name="Shop" property="price"/><br>
		<jsp:getProperty name="Shop" property="num"/><br>
	</body>
</html>
