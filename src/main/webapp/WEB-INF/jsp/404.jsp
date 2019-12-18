<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="label.error404" /></title>
</head>
<body>
<h1><spring:message code="label.errormsg1" /> </h1>
<h2> <spring:message code="label.errormsg2" /></h2>
<a href="/"><spring:message code="label.gohome" /></a>
</body>
</html>