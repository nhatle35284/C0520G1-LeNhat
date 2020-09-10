<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css"/>
</head>

<body style="background-image: url('https://www.marry.vn/wp-content/uploads/2015/10/21/Furama-Resort-Danang.jpg');">
<%@ include file="../common/header.jsp"%> @%>

<!-- header-->

<div class="menu">

    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
                <!--    <a class="navbar-brand" href="#">Navbar</a>-->
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/homePage?action=list_employee">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/homePage?action=list">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/homePage?action=list_service">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contract</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0" action="/homePage?action=search_customer" method="post">
                        <input type="hidden" name="action" value="search">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="name">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
</div>

<div>
    <div class="content" style="height: 71vh">
        <div class="container-fluid">
            <div class="row">
                <div class="col-2" style="display: flex;flex-direction: column;margin-top: 85px">
                    <a  class="btn btn-primary" style="margin: 3px" href="/homePage?action=create"><span>Add New Customer</span></a>
                    <a class="btn btn-primary" style="margin: 3px" href="/homePage?action=create_employee"><span>Add New Employee</span></a>
                    <a class="btn btn-primary" style="margin: 3px" href="/homePage?action=create_service"> <span>Add New Service</span></a>
                    <a class="btn btn-primary" style="margin: 3px" href="/homePage?action=create_contract">
                        <span>Add New Contract</span></a>
                    <a class="btn btn-primary" style="margin: 3px" href="/homePage?action=create_contract_detail"> <span>Add New Contract Detail</span></a>
                </div>
                <div class="col-10" style="margin-top: 28px">
                    <h2 style="color: darkcyan ;text-align: center">List All Customers Use Services</h2>
                    <table class="table table-striped" id="tableStudent">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">Customer id</th>
                            <th scope="col">Customer Name</th>
                            <th scope="col">Customer Gender</th>
                            <th scope="col">address</th>
                        </tr>
                        </thead>
                        <tbody style="background-color: #f7f5f2">
                        <c:forEach var="customer" items="${listCustomer}">
                            <tr>
                                <td><c:out value="${customer.customerId}"/></td>
                                <td><c:out value="${customer.customerName}"/></td>
                                <td><c:out value="${customer.customerGender}"/></td>
                                <td><c:out value="${customer.customerAddress}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../common/footer.jsp"%> @%>
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