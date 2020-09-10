<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/homePage?action=list_employee">List All Employee</a>
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
            <c:if test="${employee != null}">
                <input type="hidden" name="employee_id" value="<c:out value='${employee.employeeId}' />"/>
            </c:if>
            <tr>
                <th>customer Type Id:</th>
                <td>
                    <input type="text" name="customer_type_id" size="45"
                           value="<c:out value='${employee.employeeName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="customer_name" size="45"
                           value="${employee.employeeBirthday}"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="date" name="customer_birthday" size="15"
                           value="<c:out value='${employee.employeeIdCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Gender:</th>
                <td>
                    <input type="text" name="customer_gender" size="15"
                           value="<c:out value='${employee.employeeSalary}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>customer Id Card:</th>
                <p style="color: red"><c:out value="${message1}"></c:out></p>
                <td>
                    <input type="text" name="customer_id_card" size="15"
                           value="<c:out value='${employee.employeePhone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <p style="color: red"><c:out value="${message}"></c:out></p>
                <td>
                    <input type="text" name="customer_phone" size="15"
                           value="<c:out value='${employee.employeeEmail}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <p style="color: red"><c:out value="${message2}"></c:out></p>
                <td>
                    <input type="text" name="customer_email" size="15"
                           value="<c:out value='${employee.employeeAddress}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="customer_address" size="15"
                           value="<c:out value='${employee.positionId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="customer_address" size="15"
                           value="<c:out value='${employee.educationDegreeId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="customer_address" size="15"
                           value="<c:out value='${employee.divisionId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="customer_address" size="15"
                           value="<c:out value='${employee.userName}' />"
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
