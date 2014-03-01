<%@ page import="com.bsu.registration.servlet.ContactRegistrationServlet" %>
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
    <fmt:message key="registration.companyRegistration"/>
</h1>

<p>

    <c:set var="firstName" value="<%=request.getParameter(ContactRegistrationServlet.FIRST_NAME)%>"/>
    <c:set var="lastName" value="<%=request.getParameter(ContactRegistrationServlet.LAST_NAME)%>"/>

    <fmt:message var="lastNameLabel" key="registration.lastName"/>
    <fmt:message var="firstNameLabel" key="registration.firstName"/>
    <fmt:message var="companyNameLabel" key="registration.companyName"/>
    <fmt:message var="next" key="registration.button.next"/>

<form action="${pageContext.request.contextPath}/registration" method="post">
    <input type="hidden" name="action" value="aPersonalInfo">

    <div>
        <label for="firstName">
            ${firstNameLabel} ${firstName}
        </label>
        <input id="firstName" type="hidden" name="firstName" value="${firstName}">
    </div>
    <br>

    <div>
        <label for="lastName">
            ${lastNameLabel} ${lastName}
        </label>
        <input id="lastName" type="hidden" name="lastName" value="${lastName}">
    </div>
    <br>

    <div>
        <label for="companyName">
            ${companyNameLabel}
        </label>
        <input id="companyName" type="text" size="20" name="companyName">
    </div>
    <br>
    <input type="submit" value="${next}">
</form>
</body>
</html>
