<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setBundle basename="messages"/>
    <title>
        <fmt:message key="registration.title"/>
    </title>
</head>
<body>
<h1>
    <fmt:message key="registration.contactRegistration"/>
</h1>

<p>
    <fmt:message var="next" key="registration.button.next"/>

<form action="${pageContext.request.contextPath}/registration" method="post">
    <input type="hidden" name="action" value="aCompany">

    <div>
        <label for="firstName">
            <fmt:message key="registration.firstName"/>
        </label>
        <input id="firstName" type="text" size="20" name="firstName"/>
    </div>
    <br>

    <div>
        <label for="lastName">
            <fmt:message key="registration.lastName"/>
        </label>
        <input id="lastName" type="text" size="20" name="lastName"/>
    </div>
    <br>
    <input type="submit" value="${next}"/>
</form>
</body>
</html>