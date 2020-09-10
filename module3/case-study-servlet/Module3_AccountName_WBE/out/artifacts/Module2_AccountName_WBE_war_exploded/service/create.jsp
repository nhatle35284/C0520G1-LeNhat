<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Service</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Service</h2>
            </caption>
            <tr>
                <th>Service ID:</th>
                <p style="color: red"><c:out value="${message}"></c:out></p>
                <td>
                    <input type="text" name="service_id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="service_name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service Area:</th>
                <td>
                    <input type="text" name="service_area" id="area" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Service Cost:</th>
                <td>
                    <input type="text" name="service_cost" id="cost" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Service Max People:</th>
                <td>
                    <input type="text" name="service_max_people" id="max_people" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Rent Type ID:</th>
                <td>
                    <input type="text" name="rent_type_id" id="rent_type_id" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Service Type ID:</th>
                <td>
                    <input type="text" name="service_type_id" id="type_id" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Standard Room:</th>
                <td>
                    <input type="text" name="standard_room" id="standard_room" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Description Order Convenience:</th>
                <td>
                    <input type="text" name="description_order_convenience" id="description_order_convenience" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Pool Area:</th>
                <td>
                    <input type="text" name="pool_area" id="pool_area" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Number_Floors:</th>
                <td>
                    <input type="text" name="number_floors" id="number_floors" size="15"/>
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
