<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/9/2020
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/translate" method="post">
    <input type="text" name="key" value="${key}">
    <input type="text" name="translate" value="${translate}">
    <input type="submit" value="translate">
<%--    <button><a href="/key" methods="get"></a></button>--%>
    <form method="get">
        <a href="/key">reset</a>
    </form>
</form>

</body>
</html>
