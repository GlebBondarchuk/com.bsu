<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setBundle basename="app-messages" var="bundle" scope="page"/>
    <title><fmt:message key="title" bundle="${bundle}"/></title>
</head>
<body>
<h1><fmt:message key="congreteMessage" bundle="${bundle}"/></h1>
<P>
    <label><fmt:message key="successMessage" bundle="${bundle}"/></label>
</body>
</html>