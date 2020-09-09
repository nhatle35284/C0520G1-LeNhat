<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <p>
                <c:if test="${message != null}">
                    <a href="/homePage" class="message"><input type="button" value="${message}" style="color: red" ></a>
                </c:if>
            </p>
            <tr>
                <th>Employee ID:</th>
                <td>
                    <input type="text" name="employee_id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="employee_name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Birthday:</th>
                <td>
                    <input type="date" name="employee_birthday" id="birthday" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Employee Id Card:</th>
                <td>
                    <input type="text" name="employee_id_card" id="id_card" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="employee_salary" id="salary" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="employee_phone" id="phone" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="employee_email" id="email" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="employee_address" id="address" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Position ID:</th>
                <td>
                    <input type="text" name="position_id" id="position_id" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Education Degree ID:</th>
                <td>
                    <input type="text" name="education_degree_id" id="education_degree_id" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Division ID:</th>
                <td>
                    <input type="text" name="division_id" id="division_id" size="15"/>
                </td>
            </tr>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="user_name" id="user_name" size="15"/>
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
