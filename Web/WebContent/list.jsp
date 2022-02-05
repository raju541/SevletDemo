<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table border=1>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Mobile Number</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employelist}" var="employee">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:out value="${employee.mobile}" /></td>
                    <td><c:out value="${employee.address}" /></td>
                       <td><a href="new?action=delete&id=<c:out value="${employee.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="new?action=addemp">Add New Employee</a>
</body>
</html>