<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Product </title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th>Product ID:</th>

                <td>
                    <input type="text" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product name:</th>
                <td>
                    <input type="text" name="name" id="type_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product price:</th>
                <td>
                    <input type="text" name="price" id="name" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Product Quantity</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Product Color:</th>
                <td>
                    <input type="text" name="color" id="color" size="15"/>
                </td>
            </tr>
            <tr>
                <th> Product description:</th>
                <td>
                    <input type="text" name="description" id="description" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Product category:</th>
                <td>
                    <input type="text" name="category" id="category" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
        <button><a href="/homePage">Go Home</a></button>
    </form></div>
</body>
</html>
