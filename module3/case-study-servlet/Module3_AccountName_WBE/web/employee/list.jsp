<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <th>Employee id:</th>
        <th>Employee name:</th>
        <th>Employee ID Card:</th>
        <th>Employee Address:</th>
        <th>action:</th>
    </tr>
    <c:forEach var="employee1" items="${listEmployee}">
        <tr>
<%--            <td><c:out value="${employee1.employeeId}"/></td>--%>
            <td><c:out value="${employee1.getEmployeeName()}"/></td>
<%--            <td><c:out value="${employee1.employeeIdCard}"/></td>--%>
<%--            <td><c:out value="${employee1.employeeAddress}"/></td>--%>
            <td>
                <a href="/homePage?action=edit_employee&id=${employee1.employeeId}">Edit</a>
                <a href="/homePage?action=delete_employee&id=${employee1.employeeId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
