<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 2020/09/01
  Time: 10:19 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
    <h2><spring:message code="member.info"/></h2>
    <form:form action="step3" modelAttribute="registerRequest">
        <p>
            <label><spring:message code="email"/> : <br>
                <form:input path="email" />
                <form:errors path="email" />
            </label>
        </p>
        <p>
            <label><spring:message code="name"/> : <br>
                <form:input path="name" />
                <form:errors path="name" />
            </label>
        </p>
        <p>
            <label><spring:message code="password" /> : <br>
                <form:password path="password" />
                <form:errors path="password" />
            </label>
        </p>
        <p>
            <label><spring:message code="password.confirm"/> : <br>
                <form:password path="confirmPassword" />
                <form:errors path="confirmPassword" />
            </label>
        </p>
        <input type="submit" value="가입 완료">
    </form:form>
<%--    <form action="step3" method="post">--%>
<%--        <p>--%>
<%--            <label>이메일 : <br>--%>
<%--                <input type="text" name="email" id="email">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>이름 : <br>--%>
<%--                <input type="text" name="name" id="name">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>비밀번호 : <br>--%>
<%--                <input type="password" name="password" id="password">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>비밀번호 확인 :<br>--%>
<%--                <input type="password" name="confirmPassword" id="confirmPassword">--%>
<%--            </label>--%>
<%--        </p>--%>
<%--        <input type="submit" value="가입 완료">--%>
<%--    </form>--%>
</body>
</html>
