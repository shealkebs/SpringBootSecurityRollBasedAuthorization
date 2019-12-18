<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="label.signup" /></title>
</head>
<body>
<form action="signupUser" method="post">
			<table style="with: 50%">
				<tr>
					<td><spring:message code="label.username" /></td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td><spring:message code="label.password" /></td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.confirmpassword" /></td>
					<td><input type="password" name="passwordConfirm" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.setrole" /></td>
					<td>
					<select name="role" >
						<option value="ROLE_ADMIN"><spring:message code="label.admin" /></option>
						<option value="ROLE_USER"><spring:message code="label.user" /></option>
					</select>
					</td>
				</tr>
				<tr>
				<td><spring:message code="label.useremail" /></td>
					<td><input type="email" name="userMail" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>