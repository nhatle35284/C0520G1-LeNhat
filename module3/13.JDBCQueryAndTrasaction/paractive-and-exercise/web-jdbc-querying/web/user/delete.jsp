<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<p align="center">
    <a href="/UserServlet"><input type="submit" value="List All Users"></a>
</p>
<div align="center">
    <form method="post" style="width: 400px">
        <h3>Are you sure?</h3>
        <fieldset >
            <legend>User Management</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td>${userDelete.name}</td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td>${userDelete.email}</td>
                </tr>
                <tr>
                    <td>Country: </td>
                    <td>${userDelete.country}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
