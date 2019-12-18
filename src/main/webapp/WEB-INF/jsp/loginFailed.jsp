<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="label.failed" /></title>
</head>
<body>
<h2><spring:message code="label.failedmsg" /> </h2><br> &nbsp;
<a href="login" ><spring:message code="label.login" /></a>
</body>
</html>


