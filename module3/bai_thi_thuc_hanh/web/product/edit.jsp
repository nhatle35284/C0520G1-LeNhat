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
        <a href="/homePage">List All Product</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
<%--            <p>--%>
<%--                <c:if test="${message != null}">--%>
<%--                    <a href="/homePage" class="message"><input type="button" value="${message}" style="color: red" ></a>--%>
<%--                </c:if>--%>
<%--            </p>--%>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
            </c:if>
            <tr>
                <th>product name:</th>
                <td>
                    <input type="text" name="name" size="45" class="form-control"
                           value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="${product.price}"
                    />
                </td>
            </tr>
            <tr>
                <th>Product quantity:</th>
                <td>
                    <input type="text" name="quantity" size="15"
                           value="<c:out value='${product.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Gender:</th>
                <td>
                    <input type="text" name="color" size="15"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>description:</th>
                <p style="color: red">
                <td>
                    <input type="text" name="description" size="15"
                    value="<c:out value='${product.description}' />"
                    />
                </td>
            </tr>
            <tr>
                <th> Category:</th>
                <p style="color: red">
                <td>
                    <input type="text" name="category" size="15"
                           value="<c:out value='${product.category}' />"
                    />
                </td>
                <td>
                    <select>
                        <c:forEach items="listCategory">
                            <option>
                                <c:out value="${category.name}"></c:out>
                            </option>
                        </c:forEach>

                    </select>
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
