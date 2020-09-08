<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <!--    <link rel="stylesheet" href="../Bootstrap/bootstrap-4.5.2-dist/css/bootstrap.css">-->
    <!--    <script src="../Bootstrap/bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>-->
</head>

<body style="background-image: url('https://www.marry.vn/wp-content/uploads/2015/10/21/Furama-Resort-Danang.jpg');">
<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-3">
                <img style="width: 100px;padding: 10px;"
                     src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQlTaPPCcmHWMt6vGZ5QyfBTCSLcbmOys20dg&usqp=CAU">
            </div>
            <div class="col-3"></div>
            <div class="col-3"></div>
            <div class="col-3" style="display: flex;align-items: center" ;>
                <h3 style="color: blue">Lê Nhật</h3>
            </div>
        </div>
    </div>
</div>

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
<%--                    <form action="/homePage?action=search_customer" method="post">--%>
<%--                        <h3>Search By Name</h3>--%>
<%--                        <input type="hidden" name="action" value="search">--%>
<%--                        <input type="text" name="name">--%>
<%--                        <input type="submit" value="Search" style="background: chartreuse;width: 50px ;height: 25px">--%>
<%--                    </form>--%>
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
                    <a class="btn btn-primary" style="margin: 3px"href="/homePage?action=create_contract">
                        <span>Add New Contract</span></a>
                    <a class="btn btn-primary" style="margin: 3px" href="/homePage?action=create_contract_detail"> <span>Add New Contract Detail</span></a>
                </div>
                <div class="col-10" style="margin-top: 28px">
                    <h2 style="color: darkcyan ;text-align: center">List All Customers Use Services</h2>
                    <table class="table table-striped">
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
                    <ul id="pagination">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination" style="margin-left: 400px ;padding-top:50px ">
                                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                            </ul>
                        </nav>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="container-fluid">
            <div class="row">
                <p style="color: black;margin-left: 600px;font-size: 30px">@copy Made in Lê Nhât</p>
            </div>
        </div>
    </div>
</div>

<!--  <script src="../Bootstrap/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>-->
</body>

</html>