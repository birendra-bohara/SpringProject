<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<c:forEach var="imgname" items="${imglist}">
		<a href="resources/imgs/${imgname}" target="_blank"> <img
			alt="${imgname}" src="resources/imgs/${imgname}" width="200px;"
			height="200px;">
		</a>
	</c:forEach>
</body>
</html>