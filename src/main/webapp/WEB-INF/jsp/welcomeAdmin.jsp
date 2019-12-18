<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="label.welcomeadmin" /></title>
</head>
<body>
	<h2><spring:message code="label.welcomeadmin" /></h2>
		<form:form action="doLogout" method="get">
			<button type="submit"><spring:message code="label.logout" /></button>
		</form:form>
</body>
</html>


