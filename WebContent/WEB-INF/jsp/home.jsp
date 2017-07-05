<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hi There...!
<br />
Session : <%= session.getAttribute("name") %> <br />
Request : <%= request.getAttribute("name") %> <br />
Request with Expression Language (EL): ${name} <br />

Request with c tags: <c:out value="${name}"></c:out> <br />

<sql:query var="rs" dataSource="jdbc/SpringTestDB">
select id, name, email,text from offers
</sql:query>

<table>
<c:forEach var="row" items="${rs.rows}">
<tr>
    <td>ID: </td><td>${row.id}</td>
    <td>Name: </td><td>${row.name}</td>
    <td>E-mail: </td><td>${row.email}</td>
    <td>Text: </td><td>${row.text}</td>  
 </tr>
</c:forEach>
</table>
<br />
<p>From Database DAO</p>
<table>
<c:forEach var="row" items="${offers}">
<tr>
    <td>ID: </td><td>${row.id}</td>
    <td>Name: </td><td>${row.name}</td>
    <td>E-mail: </td><td>${row.email}</td>
    <td>Text: </td><td>${row.text}</td>  
 </tr>
</c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}/showoffers">Show Offers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">Create Offer</a></p>
</body>
</html>