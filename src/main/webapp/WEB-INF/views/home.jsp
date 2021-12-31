<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${ pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>입장</h1>
<hr>

<form method="POST" action="${ cpath }/login">
	<div>
		<input type="text" name="username" required autofocus>
		<input type="submit" value="입장">
	</div>
</form>
</body>
</html>