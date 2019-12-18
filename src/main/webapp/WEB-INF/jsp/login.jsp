
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title><spring:message code="label.title" /></title>
	</head>		
	<body>
	 <div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
       <a href="${pageContext.request.contextPath}/login?lang=en">Login (English)</a>
       &nbsp;|&nbsp;
       <a href="${pageContext.request.contextPath}/login?lang=fr">Login (French)</a>
       &nbsp;|&nbsp;
      
    </div>
		<h1><strong><spring:message code="label.login" /></strong></h1>
		<form:form action="doLogin" method="post">
			<label><spring:message code="label.username" /></label> <input type="text" name="username" />
			<label><spring:message code="label.password" /></label> <input type="Password" name="password" />
			<input type="submit"/>
			<a href="signup"><spring:message code="label.signup" /></a>
		</form:form>
	</body>
</html>
	
	
	
