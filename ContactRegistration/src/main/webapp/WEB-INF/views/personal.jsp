<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.bsu.registration.servlet.ContactRegistrationServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<html>
<head>
    <fmt:setBundle basename="messages"/>
    <title>
        <fmt:message key="registration.title"/>
    </title>
</head>
<body>
<h1>
    <fmt:message key="registration.personalInfoRegistration"/>
</h1>

<p>
    <c:set var="firstName" value="<%=request.getParameter(ContactRegistrationServlet.FIRST_NAME)%>"/>
    <c:set var="lastName" value="<%=request.getParameter(ContactRegistrationServlet.LAST_NAME)%>"/>
    <c:set var="companyName" value="<%=request.getParameter(ContactRegistrationServlet.COMPANY_NAME)%>"/>

    <fmt:message var="lastNameLabel" key="registration.lastName"/>
    <fmt:message var="firstNameLabel" key="registration.firstName"/>
    <fmt:message var="companyNameLabel" key="registration.companyName"/>
    <fmt:message var="save" key="registration.button.save"/>

<form action="${pageContext.request.contextPath}/registration" method="post">
    <input type="hidden" name="action" value="aSave">

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
            ${companyNameLabel} ${companyName}
        </label>
        <input id="companyName" type="hidden" name="companyName" value="${companyName}">
    </div>
    <br>

    <div>
        <label for="hobby">
            <fmt:message key="registration.hobby"/>
        </label>
        <input id="hobby" type="text" name="hobby">

    </div>
    <input type="submit" value="${save}">
</form>
</body>
</html>
