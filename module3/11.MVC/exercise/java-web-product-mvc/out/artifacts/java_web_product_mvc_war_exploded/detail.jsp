
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail product</title>
</head>
<body>

<label>Id: </label>
<c:out value="${product.id}"></c:out><br>
<label>Name: </label>
<c:out value="${product.name}"></c:out><br>
</body>
</html>
