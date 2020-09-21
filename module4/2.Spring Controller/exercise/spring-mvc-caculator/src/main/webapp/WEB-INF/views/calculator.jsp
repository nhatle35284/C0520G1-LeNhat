<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/9/2020
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" id="form">
    <input type="number" name="number1" value="${number1}">
    <input type="number" name="number2" value="${number2}">
    <br>
    <p>${result}</p>
    <br>
    <button type="submit" onclick="addition()">Addition(+)</button>
    <button type="submit" onclick="subtraction()">Subtraction(-)</button>
    <button type="submit" onclick="multiplication()">Multiplication(X)</button>
    <button type="submit" onclick="division()">Division(/)</button>
</form>

<script>
    function addition() {
        document.getElementById("form").action = "/add";
        document.getElementById("from").submit();
    }function subtraction() {
        document.getElementById("form").action = "/sub";
        document.getElementById("from").submit();
    }function multiplication() {
        document.getElementById("form").action = "/mul";
        document.getElementById("from").submit();
    }function division() {
        document.getElementById("form").action = "/dis";
        document.getElementById("from").submit();
    }
</script>
</body>
</html>
