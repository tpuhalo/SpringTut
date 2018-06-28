<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="resources/css/test/test-main.css" var="testMainCSS/" />
<link href="${testMainCSS}" rel="stylesheet" />
<title>Form Tags Results</title>
</head>
<body>

	<h1>Congs</h1>
	<h2>Details below</h2>
	<hr />
	<div style="margin-left: 600px; width: auto">
		Organization name:
		<h3>
			<b>${orgreg.orgName }</b>
		</h3>
		<hr />
		Country:
		<h3>
			<b>${orgreg.country}</b>
		</h3>
		<hr />
		Turnover:
		<h3>
			<c:forEach var="entry" items="${turnoverlist}">
				<c:if test="${orgreg.turnover eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<hr />
		Type:
		<h3>
			<c:forEach var="entry" items="${typelist}">
				<c:if test="${orgreg.type eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<hr />
		Organization age:
		<h3>
			<c:forEach var="entry" items="${serviceLength}">
				<c:if test="${orgreg.serviceLength eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<hr />
		Registered previously
		<h3>
			<c:forEach var="entry" items="${registeredPreviouslyList}">
				<c:if test="${orgreg.registeredPreviously eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<hr />
		Like me:
		<h3>
			<c:choose>
				<c:when test="${orgreg.like eq 'yes'}">
					<b>Of course</b>
				</c:when>
				<c:otherwise>
					<b>No :(</b>
				</c:otherwise>
			</c:choose>
		</h3>
		<hr />
		Optional services
		<h3>
			<c:forEach var="entry1" items="${subscriptionList}">
				<c:forEach var="entry2" items="${orgreg.optionalServices}">
					<c:if test="${entry2 eq entry1.key}">
						<c:set var="optservice" scope="request"
							value="${optservice}${entry1.value}, " />
					</c:if>
				</c:forEach>
			</c:forEach>
			<b>${optservice.substring(0, optservice.length()-2)}</b>
		</h3>
		<hr />
		Premium services
		<h3>
			<c:forEach var="entry1" items="${premiumServicesList}">
				<c:forEach var="entry2" items="${orgreg.premiumServices}">
					<c:if test="${entry2 eq entry1.key}">
						<c:set var="premiumservice" scope="request"
							value="${premiumservice}${entry1.value}, " />
					</c:if>
				</c:forEach>
			</c:forEach>
			<b>${premiumservice.substring(0, premiumservice.length()-2)}</b>
		</h3>
		<hr />
		Overseas operation:
		<h3>${orgreg.overseasOperation}</h3>
		<hr />
		Employee strength:
		<h3>
			<c:forEach var="entry" items="${employeeStrengthList}">
				<c:if test="${orgreg.employeeStrength eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>

	</div>
</body>
</html>