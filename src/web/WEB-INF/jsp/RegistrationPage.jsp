<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setBundle basename="app-messages" var="bundle" scope="page"/>
    <title><fmt:message key="title" bundle="${bundle}"/></title>
</head>
<body>
<h1>${pageHeader}</h1>

<P>

<form action="${pageContext.request.contextPath}/" method=POST>
    <c:set var="action" value="name_registration"/>
    <input type="hidden" name="formId" value="${formId}">
    <label><fmt:message key="label.firstname" bundle="${bundle}"/></label>
    <c:choose>
        <c:when test="${empty firstname}">
            <input type=text size=20 name=firstname>
        </c:when>
        <c:otherwise>
            <label>${firstname}</label>
        </c:otherwise>
    </c:choose>

    <br>
    <label><fmt:message key="label.lastname" bundle="${bundle}"/></label>
    <c:choose>
        <c:when test="${empty lastname}">
            <input type=text size=20 name=lastname>
        </c:when>
        <c:otherwise>
            <label>${lastname}</label>
        </c:otherwise>
    </c:choose>

    <c:if test="${not empty lastname}">
        <br>
        <label><fmt:message key="label.companyname" bundle="${bundle}"/></label>
        <c:choose>
            <c:when test="${empty companyname}">
                <input type=text size=20 name=companyname>
            </c:when>
            <c:otherwise>
                <label>${companyname}</label>
            </c:otherwise>
        </c:choose>
        <c:set var="action" value="company_registration"/>
    </c:if>

    <c:if test="${not empty companyname}">
        <br>
        <label><fmt:message key="label.hobby" bundle="${bundle}"/></label>
        <c:choose>
            <c:when test="${empty hobby}">
                <input type=text size=20 name=hobby>
            </c:when>
            <c:otherwise>
                <label>${hobby}</label>
            </c:otherwise>
        </c:choose>
        <c:set var="action" value="hobby_registration"/>
    </c:if>
    <input type="hidden" name="action" value="${action}">
    <input type=submit value=${btnTitle}>
</form>
</body>
</html>