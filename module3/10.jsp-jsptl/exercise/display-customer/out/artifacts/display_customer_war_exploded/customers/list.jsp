
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="customerList">
    <h1>Danh Sách Khách Hàng</h1>
<table style="border: groove">
    <tr>
        <th>Customer Name</th>
        <th>Customer BirthDay</th>
        <th>Customer Address</th>
        <th>Customer Image</th>
    </tr>
        <c:forEach var="customer" items="${customerListServlet}">
            <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.birthday}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><c:out value="${customer.img}"></c:out></td>
            </tr>
        </c:forEach>

</table>
</form>
</body>
</html>
