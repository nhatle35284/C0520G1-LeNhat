<%@ taglib prefix="c" uri="http://java.sun.com/jstl/xml_rt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jstl/xml_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/9/2020
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Sandwich has condiment is: </h2>
<p>${condiment[0]}</p>
<p>${condiment[1]}</p>
<p>${condiment[2]}</p>
<p>${condiment[3]}</p>
<form action="/sandwich"><input type="submit" value="back"></form>
</body>
</html>
