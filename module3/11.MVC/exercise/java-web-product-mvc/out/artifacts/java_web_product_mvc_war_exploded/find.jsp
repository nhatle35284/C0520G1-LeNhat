<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/8/2020
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<label>Id: </label>
<c:out value="${product.id}"></c:out><br>
<label>Name: </label>
<c:out value="${product.name}"></c:out><br>

</body>
</html>
