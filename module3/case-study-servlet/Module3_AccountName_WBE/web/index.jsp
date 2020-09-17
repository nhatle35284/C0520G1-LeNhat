<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/9/2020
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>


  <div class="menu">

    <div class="row">
      <div class="col-12">
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
            <tr>
              <th scope="col">Customer id</th>
              <th scope="col">Customer Name</th>
              <th scope="col">Customer Gender</th>
              <th scope="col">address</th>
            </tr>
            <%--        <c:forEach var="customer" items="${listCustomer}">--%>
            <%--            <tr>--%>
            <%--                <td><c:out value="${customer.customerId}"/></td>--%>
            <%--                <td><c:out value="${customer.customerName}"/></td>--%>
            <%--                <td><c:out value="${customer.customerGender}"/></td>--%>
            <%--                <td><c:out value="${customer.customerAddress}"/></td>--%>
            <%--            </tr>--%>
            <%--        </c:forEach>--%>
            </tbody>
          </table>
        </div>
      </div>
    </div>


  </body>
</html>
