<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/8/2020
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="discount" method="post">
  <label>Description : </label>
    <input type="text" name="discount" placeholder="discount">
    <label>Price : </label>
    <input type="text" name="price" placeholder="price">
    <label>Discount Percent: </label>
    <input type="text" name="percent" placeholder="percent">
    <input type="submit" id="submit" name="price" value="Calculate Discount">
  </form>
  </body>
</html>
