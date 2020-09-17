<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="../lib/bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../lib/datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body style="background-image: url('https://photo2.tinhte.vn/data/attachment-files/2019/07/4722533_Cover_Picture_33.jpg')">
<%@include file="../common/header.jsp" %>

<div class="menu">

    <div class="row">
        <div class="col-12">
            <div class="col-12" style="margin-top: 28px">
                <h2 style="color: darkcyan ;text-align: center">List All Customers Use Services</h2>

                <a  class="btn btn-primary" style="margin: 3px" href="/homePage?action=create"><span>Add New Product</span></a>

                <form class="form-inline my-2 my-lg-0" action="/homePage?action=search" method="post" style="float: right">
                    <input type="hidden" name="action" value="search">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="name">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>

                <table class="table table-striped" id="tableStudent">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col"> id</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">price</th>
                        <th scope="col">quantity</th>
                        <th scope="col">color</th>
                        <th scope="col">category</th>
                        <th scope="col">action</th>
                    </tr>

                    </thead>
                    <tbody style="background-color: #f7f5f2">
                    <c:forEach var="product" items="${listProduct}">
                        <tr>
                            <td><c:out value="${product.id}"/></td>
                            <td><c:out value="${product.productName}"/></td>
                            <td><c:out value="${product.price}"/></td>
                            <td><c:out value="${product.quantity}"/></td>
                            <td><c:out value="${product.color}"/></td>
                            <td><c:out value="${product.category}"/></td>
                            <td>
                                <button><a href="/homePage?action=edit&id=${product.id}">Edit</a></button>
                                <button><a href="/homePage?action=delete&id=${product.id}">Delete</a></button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <%@include file="../common/footer.jsp" %>

    <script src="../lib/jquery/jquery-3.5.1.min.js"></script>
    <script src="../lib/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../lib/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="../lib/bootstrap413/js/bootstrap.min.js"></script>
</body>
</html>
