<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<center>
    <h2>List All Customer</h2>
</center>
<form action="/homePage?action=search_customer" method="post">
    <h3>Search By Name</h3>
    <input type="hidden" name="action" value="search">
    <input type="text" name="name">
    <input type="submit" value="Search" style="background: chartreuse;width: 50px ;height: 25px">
</form>
<button style="background: chartreuse;width: 200px ;height: 50px">
    <a href="/homePage?action=list_user_service" style="color: black">List Customer Using Service</a></button>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Customer id:</th>
                    <th>Customer name:</th>
                    <th>Customer gender:</th>
                    <th>Customer address:</th>
                    <th>action:</th>
                    <th>action:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${listCustomer}">
                    <tr>
                        <td><c:out value="${customer.customerId}"/></td>
                        <td><c:out value="${customer.customerName}"/></td>
                        <td><c:out value="${customer.customerGender}"/></td>
                        <td><c:out value="${customer.customerAddress}"/></td>
                        <td>
                            <button><a href="/homePage?action=edit&id=${customer.customerId}">Edit</a></button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#a${customer.customerId}">
                                Delete
                            </button>
                            <!-- Modal -->
                        </td>
                        <div class="modal fade" id="a${customer.customerId}" tabindex="-1" role="dialog"
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
                                        Customer : ${customer.customerName}
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                        </button>
                                        <button type="button" class="btn btn-primary"><a
                                                href="/homePage?action=delete&id=${customer.customerId}" style="color: black">Delete</a>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
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
