<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setBundle basename="app-messages" var="bundle" scope="page"/>
    <title><fmt:message key="title" bundle="${bundle}"/></title>
</head>
  <body>
      <h1><fmt:message key="caption.welcome" bundle="${bundle}"/></h1>
      <a href="${pageContext.request.contextPath}\contact-registration">
          <fmt:message key="link.caption" bundle="${bundle}"/>
      </a>
  </body>
</html>