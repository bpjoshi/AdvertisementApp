<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Adverts</title>
</head>
<body>
	<table>
	<c:forEach var="advert" items="${adverts}">
    <tr><td>Name</td> <td>${advert.name}</td></tr>
    <tr><td>Email</td> <td>${advert.email}</td></tr>
    <tr><td>Service</td> <td>${advert.text}</td></tr>
	</c:forEach>
	</table>
</body>
</html>