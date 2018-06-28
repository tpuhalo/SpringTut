<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@ModelAttributeTest</title>
<style>
h1, h2 {
	color: black;
	text-align: center;
}
</style>
</head>
<body>
	<h1>@ModelAttribute</h1>
	<hr />
	<div align="center">
		<c:if test="${testdata5a != null && testdata5b != null }">
			<h3 style="color: red">City: ${testdata5a }</h3>
			<h3 style="color: red">Postal code: ${testdata5b }</h3>
		</c:if>
		<c:if test="${testdata6 != null }">
		Address relocated to: <h3 style="color: blue">${testdata6.city },
				${testdata6.zipCode }</h3>
		</c:if>
	</div>
</body>
</html>