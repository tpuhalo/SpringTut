<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@RequestMapping test results2</title>
</head>
<body>
	<div align="center">
		<h1>${testserial}:@RequestMapingand param test Results2</h1>
		<c:forEach var="parameter" items="${param}">
			<h3 style="color: black">
				<c:out value="${parameter.key }" />
				=
				<c:out value="${parameter.value }" />
			</h3>
		</c:forEach>

	</div>

</body>
</html>