<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/9/2020
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
//contract_detail_id,contract_id,attach_service_id,quantity
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Contract Detail</h2>
            </caption>
            <tr>
                <th>contract_detail_id:</th>
                <td>
                    <input type="text" name="contract_detail_id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>contract_id:</th>
                <td>
                    <input type="text" name="contract_id" id="contract_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>attach_service_id:</th>
                <td>
                    <input type="text" name="attach_service_id" id="attach_service_id" size="15"/>
                </td>
            </tr>
            <tr>
                <th>quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Service Id:</th>
                <td>
                    <input type="text" name="service_id" id="service_id" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
        <button><a href="/homePage">Go Home</a></button>
    </form>
</div>
</body>
</html>
