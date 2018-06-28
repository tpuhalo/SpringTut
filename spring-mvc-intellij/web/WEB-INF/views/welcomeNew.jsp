<%--
  Created by IntelliJ IDEA.
  User: tpuhalo
  Date: 24.4.2018.
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:forEach var="messageItem" items="${myWelcomeMessage}">
    <c:out value="${messageItem}"></c:out>
  </c:forEach>
  </body>
</html>
