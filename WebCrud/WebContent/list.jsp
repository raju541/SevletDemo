<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of all Employees</title>
</head>
<body>
<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="emp">
				<tr>
					<td><c:out value="${emp.id }"/></td>
					<td><c:out value="${emp.name }"/></td>
					<td><c:out value="${emp.address }"/></td>
					<td><c:out value="${emp.phone }"/></td>
					<td><c:out value="${emp.salary }"/></td>
					<td><a href="new?action=delete&id=<c:out value="${emp.id }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
</table>
 <a href="new?action=addemp">Add New Employee</a>

</body>
</html>