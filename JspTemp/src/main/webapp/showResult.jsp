<%@page import="beans.ComputerBean" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:useBean id="ComputerBean" type="beans.ComputerBean" scope="request"/>
		<jsp:getProperty property="a" name="ComputerBean" />
		<jsp:getProperty property="ch" name="ComputerBean"/>
		<jsp:getProperty property="b" name="ComputerBean"/>
		=
		<jsp:getProperty property="result" name="ComputerBean"/>

	</body>
</html>
