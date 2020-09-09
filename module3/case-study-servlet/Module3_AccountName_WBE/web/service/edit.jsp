<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2020
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Service</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <p>
                <c:if test="${message != null}">
                    <a href="/homePage" class="message"><input type="button" value="${message}" style="color: red" ></a>
                </c:if>
            </p>
            <c:if test="${service != null}">
                <input type="hidden" name="service_id" value="<c:out value='${service.serviceId}' />"/>
            </c:if>
            <tr>
                <th>Service Name</th>
                <td>
                    <input type="text" name="service_name" size="45"
                           value="<c:out value='${service.serviceName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Service Area:</th>
                <td>
                    <input type="text" name="service_area" size="45"
                           value="${service.serviceArea}"
                    />
                </td>
            </tr>
            <tr>
                <th>Service Cost:</th>
                <td>
                    <input type="date" name="service_cost" size="15"
                           value="<c:out value='${service.serviceCost}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Service Max People:</th>
                <td>
                    <input type="text" name="service_max_people" size="15"
                           value="<c:out value='${service.serviceMaxPeople}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Rent Type Id:</th>
                <td>
                    <input type="text" name="rent type id" size="15"
                           value="<c:out value='${service.rentTypeId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Service Type Id:</th>
                <td>
                    <input type="text" name="service_type_id" size="15"
                           value="<c:out value='${service.serviceTypeId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Standard Room:</th>
                <td>
                    <input type="text" name="standard_room" size="15"
                           value="<c:out value='${service.standardRoom}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description Order Convenience:</th>
                <td>
                    <input type="text" name="description_order_convenience" size="15"
                           value="<c:out value='${service.descriptionOrderConvenience}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Pool Area:</th>
                <td>
                    <input type="text" name="pool_area" size="15"
                           value="<c:out value='${service.poolArea}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>number Floor:</th>
                <td>
                    <input type="text" name="numberFloor" size="15"
                           value="<c:out value='${service.numberFloor}' />"
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
