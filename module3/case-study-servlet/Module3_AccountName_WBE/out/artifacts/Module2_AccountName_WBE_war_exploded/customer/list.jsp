<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" cellpadding="5">
    <tr>
        <th>Customer id:</th>
        <th>Customer name:</th>
        <th>Customer gender:</th>
        <th>Customer address:</th>
        <th>action:</th>
    </tr>
    <c:forEach var="customer" items="${listCustomer}">
        <tr>
            <td><c:out value="${customer.customerId}"/></td>
            <td><c:out value="${customer.customerName}"/></td>
            <td><c:out value="${customer.customerGender}"/></td>
            <td><c:out value="${customer.customerAddress}"/></td>
            <td>
                <a href="/homePage?action=edit&id=${customer.customerId}">Edit</a>
                <a href="/homePage?action=delete&id=${customer.customerId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
