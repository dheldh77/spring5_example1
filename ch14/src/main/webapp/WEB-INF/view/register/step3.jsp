<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 2020/09/01
  Time: 10:26 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
    <p>
        <spring:message code="register.done" arguments="${registerRequest.name}"/>
    </p>
    <p>
        <a href="<c:url value='/main'/>">
            [<spring:message code="go.main"/>]
        </a>
    </p>
</body>
</html>
