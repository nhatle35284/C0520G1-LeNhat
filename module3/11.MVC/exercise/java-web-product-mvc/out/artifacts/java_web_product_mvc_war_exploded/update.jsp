<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/8/2020
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<form action="/productServlet" method="post">

    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${product.id}">
    <label>Name: </label>
    <input type="text" name="name" value="${product.name}">
    <input type="text" name="name"/><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
