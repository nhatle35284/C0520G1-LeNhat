
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body cred>
<form method="post" action="customerList">


    <h1 style="margin-left: 100px ">Danh Sách Khách Hàng</h1>
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
            <td>${customer.img}</td>
            </tr>
        </c:forEach>




    <img src="avatar.jpg">


    <img src="module3/10.jsp-jsptl/exercise/display-customer/avatar.jpg <%=request.getAttribute("ur l")%>"
         width="200px">
</table>
</form>
</body>
</html>
