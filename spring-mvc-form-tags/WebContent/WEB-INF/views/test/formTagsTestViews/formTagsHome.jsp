<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="resources/css/test/test-main.css" var="testMainCSS/" />
<link href="${testMainCSS}" rel="stylesheet" />
<title>Tags form Test</title>
</head>
<body>

	<div>
		<h1>Welcome to Form Tags Bed</h1>
		<hr />
		<h3>Register Your Organization</h3>
		<form:form action="registerOrg" modelAttribute="orgRegistration">
			<table>
				<tr>
					<td><form:label path="orgName"> Name of organization</form:label></td>
					<td><form:input path="orgName"
							placeholder="Enter organization name" /></td>
				</tr>
				<tr>
					<td><form:label path="country">Country</form:label></td>
					<td><form:select path="country">
							<form:option value="NONE">---SELECT---</form:option>
							<form:option value="Australia">Australia</form:option>
							<form:option value="Hrvatska">Hrvatska</form:option>
							<form:option value="India">India</form:option>
							<form:option value="USA">USA</form:option>
						</form:select></td>
				<tr>
					<td><form:label path="turnover">Turnover</form:label></td>
					<td><form:select path="turnover" items="${turnoverlist}" /></td>
				</tr>
				<tr>
					<td><form:label path="type">Type</form:label></td>
					<td><form:select path="type">
							<form:option value="NONE">---SELECT---</form:option>
							<form:options items="${typelist }" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="serviceLength">Organization age</form:label></td>
					<td><form:select path="serviceLength" items="${serviceLength}" /></td>
				</tr>
				<tr>
					<td><form:label path="registeredPreviously">Registered previously</form:label></td>
					<td><form:checkbox path="registeredPreviously"
							items="${registeredPreviouslyList}" />
				</tr>
				<tr>
					<td><form:label path="like">Do you like me?</form:label></td>
					<td><form:checkbox path="like" value="yes" />Like</td>
				</tr>
				<tr>
					<td><form:label path="optionalServices">Subscribe</form:label></td>
					<td><form:checkbox path="optionalServices"
							value="emailService" /> ${subscriptionList.emailService} <form:checkbox
							path="optionalServices" value="promotionalService" />${subscriptionList.promotionalService}
						<form:checkbox path="optionalServices" value="weeklyUpdate" />${subscriptionList.weeklyUpdate}
					</td>
				</tr>
				<tr>
					<td><form:label path="premiumServices">Premium services</form:label></td>
					<td><form:checkboxes path="premiumServices"
							items="${premiumServicesList}" /></td>
				</tr>
				<tr>
					<td><form:label path="overseasOperation">Overseas operation</form:label></td>
					<td><form:radiobutton path="overseasOperation" value="Yes" />Yes
						<form:radiobutton path="overseasOperation" value="No" />No
				</tr>
				<tr>
					<td><form:label path="employeeStrength">Employee count</form:label></td>
					<td><form:radiobuttons path="employeeStrength"
							items="${employeeStrengthList}" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Submit" />
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>