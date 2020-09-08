<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<center>
    <h2>List Customer Using Service</h2>
</center>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Customer id:</th>
                    <th>Customer name:</th>
                    <th>Service id:</th>
                    <th>Service name:</th>
                    <th>Contract ID:</th>
                    <th>Attach Service Name:</th>
                    <th>action:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customerUserService" items="${listUserService}">
                    <tr>
                        <td><c:out value="${customerUserService.customerId}"/></td>
                        <td><c:out value="${customerUserService.customerName}"/></td>
                        <td><c:out value="${customerUserService.serviceId}"/></td>
                        <td><c:out value="${customerUserService.serviceName}"/></td>
                        <td><c:out value="${customerUserService.contractId}"/></td>
                        <td><c:out value="${customerUserService.attachServiceName}"/></td>
                        <td>
                            <a href="/homePage?action=edit_service&id=${customerUserService.serviceId}">Edit Service</a>
                            <a href="/homePage?action=delete_service&id=${customerUserService.serviceId}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>
</body>
</html>
