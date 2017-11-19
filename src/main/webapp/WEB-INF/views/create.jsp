<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <link href="${pageContext.request.contextPath}/static/css/advert.css"
	rel="stylesheet" type="text/css" /> --%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create An Advert</title>
</head>
<body>
	<h2>Post your Advert here</h2>
	<hr>
	<form:form method="post"
		action="${pageContext.request.contextPath}/doCreate" commandName="advert">

		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td><form:input class="control" path="name" name="name" type="text" /><br>
				<form:errors path="name" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><form:input class="control" path="email" name="email" type="text" /><br>
				<form:errors path="email" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Advertisement:</td>
				<td><form:textarea class="control" path="text" name="text" rows="10" cols="10"></form:textarea><br>
				<form:errors path="text" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create advert" type="submit" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>