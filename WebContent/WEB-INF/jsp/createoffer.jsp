<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" />
<title>Create Offer</title>
</head>
<body>
	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
		<table>
			<tr>
				<td>Name</td>
				<td>
				<td><sf:input type="text" name="name" path="name"></sf:input><sf:errors path="name" cssClass="error"></sf:errors> </td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
				<td><sf:input type="text" name="email" path="email"></sf:input> <sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>Offer</td>
				<td>
				<td><sf:textarea rows="10" cols="20" name="text" path="text"></sf:textarea> <sf:errors path="text" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<td><input type="submit" value="Create Offer"></input></td>
			</tr>
		</table>
	</sf:form>
	<p>Create Offer to be setup</p>
</body>
</html>