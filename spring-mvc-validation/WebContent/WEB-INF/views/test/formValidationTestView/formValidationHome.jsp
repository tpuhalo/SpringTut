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
<title>Validation Test</title>
<style>
td {
	align: center
}
</style>
</head>
<body>
	<div align="center">
		<h1 class="ch1">Validation Test</h1>
		<hr />
		<h3>Please register</h3>
		<form:form action="registerOrgRep" modelAttribute="orgrep">
			<table>
				<tr>
					<td><form:label path="firstName" cssClass="clabel">First name: </form:label></td>
					<td><form:input path="firstName"
							placeholder="Enter first name" cssClass="ciput" /></td>
					<td><form:errors path="firstName" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="lastName" cssClass="clabel">Last name: </form:label></td>
					<td><form:input path="lastName" placeholder="Enter surname"
							cssClass="ciput" /></td>
					<td><form:errors path="lastName" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="age" cssClass="clabel">Age </form:label></td>
					<td><form:input path="age" placeholder="Enter age"
							cssClass="ciput" /></td>
					<td><form:errors path="age" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="zipCode" cssClass="clabel">Zip Code </form:label></td>
					<td><form:input path="zipCode" placeholder="Enter zip code"
							cssClass="ciput" /></td>
					<td><form:errors path="zipCode" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="email" cssClass="clabel">Email </form:label></td>
					<td><form:input path="email" placeholder="Enter email"
							cssClass="ciput" /></td>
					<td><form:errors path="email" cssClass="cb"></form:errors></td>

					<spring:hasBindErrors name="orgrep">
						<c:forEach items="${errors.globalErrors}" var="globalError">
							<c:if test="${fn:contains(globalError, 'Email')}">
								<c:out value="${globalError.defaultMessage}" />
							</c:if>
						</c:forEach>
					</spring:hasBindErrors>
				</tr>
				<tr>
					<td><form:label path="verifyEmail" cssClass="clabel">Verify Email </form:label></td>
					<td><form:input path="verifyEmail" placeholder="Confirm email"
							cssClass="ciput" /></td>
					<td><form:errors path="verifyEmail" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="password" cssClass="clabel">Password </form:label></td>
					<td><form:password path="password" placeholder="Password"
							cssClass="ciput" /></td>
					<td><form:errors path="password" cssClass="cb"></form:errors></td>

					<spring:hasBindErrors name="orgrep">
						<c:forEach items="${errors.globalErrors}" var="globalError">
							<c:if test="${fn:contains(globalError, 'Password')}">
								<c:out value="${globalError.defaultMessage}" />
							</c:if>
						</c:forEach>
					</spring:hasBindErrors>
				</tr>
				<tr>
					<td><form:label path="verifyPassword" cssClass="clabel">Verify password </form:label></td>
					<td><form:password path="verifyPassword"
							placeholder="Verify password" cssClass="ciput" /></td>
					<td><form:errors path="verifyPassword" cssClass="cb"></form:errors></td>
				</tr>
				<td />
				<td align="center"><input type="submit" value="Submit"
					class="csubmit" /></td>
			</table>
			<hr />
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<c:if test="${formerroes ne null }">
				<a href="${contextPath}/formValidation/home" style="font-size: 17px">Click
					here to start again</a>
			</c:if>
		</form:form>
	</div>

</body>
</html>