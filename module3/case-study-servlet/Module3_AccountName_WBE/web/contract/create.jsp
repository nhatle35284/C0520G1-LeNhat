<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Contract</h2>
            </caption>
            <tr>           //    contract_id,contrac_start_date,contrac_end_date,contract_deposit,contract_total_money,
                //    employee_id,customer_id,service_id
                <th>Contract ID:</th>
                <td>
                    <input type="text" name="contract_id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract Start Date:</th>
                <td>
                    <input type="date" name="contract_start_date" id="start_date" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract End Date:</th>
                <td>
                    <input type="date" name="contract_end_date" id="end_date" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Contract Deposit:</th>
                <td>
                    <input type="text" name="contract_deposit" id="deposit" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Contract Total Money:</th>
                <td>
                    <input type="text" name="contract_total_money" id="total_money" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Employee Id:</th>
                <td>
                    <input type="text" name="employee_id" id="employee_id" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Customer Id:</th>
                <td>
                    <input type="text" name="customer_id" id="customer_id" size="15"/>
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
