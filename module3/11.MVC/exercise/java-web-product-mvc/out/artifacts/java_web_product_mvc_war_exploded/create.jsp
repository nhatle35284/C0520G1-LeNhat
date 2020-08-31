<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/8/2020
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<form action="/productServlet" method="post">

    <input type="hidden" name="action" value="create">
    <label>Name: </label>
    <input type="text" name="name"/><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
