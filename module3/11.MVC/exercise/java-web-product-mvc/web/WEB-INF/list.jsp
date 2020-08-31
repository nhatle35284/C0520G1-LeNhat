<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/8/2020
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<a href="/productServlet?action=create">Create product</a>
<p style="color: green">${message}</p>

<h3>List Student</h3>
<table style="border:solid">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Action</th>
    </tr>

        <c:forEach var="product" items="${listProduct}">
            <tr>
            <td>${product.id}</td>
            <td><a href="/productServlet?action=detail&id=${product.id}">${product.name}</a></td>
            <td><a href="/productServlet?action=update&id=${product.id}">Update</a></td>
            <td><a href="/productServlet?action=delete&id=${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
</table>
</body>
</html>
