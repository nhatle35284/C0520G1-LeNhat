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
    <h2>List All Service</h2>
    <%--    <button style="background: chartreuse;width: 200px ;height: 50px">--%>
    <%--        <a href="/homePage" style="color: black">List Customer Using Service</a></button>--%>
</center>
<form action="/homePage?action=search_service" method="post">
    <h3>Search By Name</h3>
    <input type="hidden" name="action" value="search">
    <input type="text" name="name">
    <input type="submit" value="Search" style="background: chartreuse;width: 50px ;height: 25px">
</form>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Service Id:</th>
                    <th>Service Name:</th>
                    <th>Service Area:</th>
                    <th>Service Cost:</th>
                    <th>Service Max People:</th>
                    <th>Rent Type Id:</th>
                    <th>Service Type Id:</th>
                    <th>Standard Room:</th>
                    <th>Description Order Convenience:</th>
                    <th>Pool Area:</th>
                    <th>Number Floor:</th>
                    <th>action:</th>
                    <th>action:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${listService}">
                    <tr>
                        <td><c:out value="${service.serviceId}"/></td>
                        <td><c:out value="${service.serviceName}"/></td>
                        <td><c:out value="${service.serviceArea}"/></td>
                        <td><c:out value="${service.serviceCost}"/></td>
                        <td><c:out value="${service.serviceMaxPeople}"/></td>
                        <td><c:out value="${service.rentTypeId}"/></td>
                        <td><c:out value="${service.serviceTypeId}"/></td>
                        <td><c:out value="${service.standardRoom}"/></td>
                        <td><c:out value="${service.descriptionOrderConvenience}"/></td>
                        <td><c:out value="${service.poolArea}"/></td>
                        <td><c:out value="${service.numberFloor}"/></td>
                        <td>
                            <button><a href="/homePage?action=edit_service&id=${service.serviceId}">Edit</a></button>
                        </td>
                        <td>
<%--                            <button><a href="/homePage?action=delete_service&id=${service.serviceId}">Delete</a>--%>
<%--                            </button>--%>
                            <div class="modal fade" id="a${service.serviceId}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Do you want delete?</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Service : ${service.serviceName}
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <button type="button" class="btn btn-primary"><a
                                                    href="/homePage?action=delete_employee&id=${service.serviceId}" style="color: black">Delete</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
<script src="../bootstrap413/js/bootstrap.min.js"></script>
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
