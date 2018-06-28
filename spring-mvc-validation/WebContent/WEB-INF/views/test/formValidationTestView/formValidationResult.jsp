<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="resources/css/test/test-main.css" var="testmainCSS/" />
<link href="${testmainCSS}" rel="stylesheet" />
<title>Validation result</title>
<style>
td, h3 {
	align: center
}
</style>
</head>
<body>
	<h1 class="ch1">You are registered</h1>
	<h2 class="ch2">Details below</h2>
	<hr />
	<div style="margin-left: 600px; width: auto">
		<h3>
			Name:<b>${orgrep.firstName} ${orgrep.lastName}, Age:
				${orgrep.age}, Zip code: ${orgrep.zipCode}, Email: ${orgrep.email}</b>
		</h3>
		<h3>
		Password: ${orgrep.password}
		</h3>
	</div>
	<hr />

	<div align="center">
		<c:set var="contextPath" value="${pageContext.request.contextPath }" />
		<a href="${contextPath}/formValidation/home" style="font-size: 17px">
			Click here to go home </a>
	</div>
</body>
</html>