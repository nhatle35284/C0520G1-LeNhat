<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/homePage?action=list">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="customer_id" value="<c:out value='${customer.customerId}' />"/>
            </c:if>
            <tr>
                <th>customer Type Id:</th>
                <td>
                    <input type="text" name="customer_type_id" size="45"
                           value="<c:out value='${customer.customerTypeId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="customer_name" size="45"
                           value="${customer.customerName}"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="text" name="customer_birthday" size="15"
                           value="<c:out value='${customer.customerBirthday}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Gender:</th>
                <td>
                    <input type="text" name="customer_gender" size="15"
                           value="<c:out value='${customer.customerGender}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>customer Id Card:</th>
                <td>
                    <input type="text" name="customer_id_card" size="15"
                           value="<c:out value='${customer.customerIdCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="customer_phone" size="15"
                           value="<c:out value='${customer.customerPhone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="customer_email" size="15"
                           value="<c:out value='${customer.customerEmail}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="customer_address" size="15"
                           value="<c:out value='${customer.customerAddress}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
