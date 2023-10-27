<%@ page language="java" contentType="text/html; charset=utf-8"
			pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
<form action="HandleConmuterServlet" method="post">
	输入两个数：<input type="text" name="First"/>
	<select name="Ch">
		<option>+(加)</option>
		<option>-(减)</option>
		<option>*(乘)</option>
		<option>/(除)</option>
	</select>
	<input type="text" name="Second"/><br>
	<input type="submit" value="计算">
</form>
</body>
</html>
