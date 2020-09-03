<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div align="center">
    <h1>User Management</h1>
    <table>
        <tr>
            <th>
                <h3>
                    <a href="/UserServlet?action=create"><input type="submit" value="Add New User"></a>
                </h3>
            </th>
            <th>
                <h3>
                    <a href="/UserServlet?action=sort"><input type="submit" value="Sort User By Name"></a>
                </h3>
            </th>
        </tr>
    </table>
    <form action="/UserServlet?action=search" method="post">
        <input type="text" name="country" id="country" placeholder="Search user by country">
        <input type="submit" value="Search">
    </form>
    <p>
        <c:if test="${message != null}">
            <a href="/UserServlet" class="message"><input type="submit" value="${message}"></a>
        </c:if>
    </p>
</div>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/UserServlet?action=edit&id=${user.id}"><input type="submit" value="Edit"></a>
                    <a href="/UserServlet?action=delete&id=${user.id}"><input type="submit" value="Delete"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
