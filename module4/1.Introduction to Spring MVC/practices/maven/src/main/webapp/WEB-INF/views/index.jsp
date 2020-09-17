<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Go Out</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach var="student" items="${list}">
        <tr>
            <td>${student.name}</td>
            <td>${student.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
