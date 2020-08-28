<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/8/2020
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>c:out example</h2>
  <c:out value="${'This is true: 10 > 1 '}"/>
  <br/>
  Tag: <c:out value="${'<atag> , &'}"/>
  <br>
  <h2>c:set example</h2>
  <c:set scope="request" var="greeting" value="Hello every body" />
  Greeting: <c:out value="${greeting}"/>
  <br>
  <c:set var = "salary" scope = "session" value = "${2000*3}"/>
  <c:out value = "${salary}"/>
  <br>
  <h2>c:catch example</h2>
  <c:catch var ="ex">
    <%
      int a = 100/0;
    %>
  </c:catch>
  <c:if test = "${ex != null}">
    Exception : ${ex}
    <br />
    Message: ${ex.message}
  </c:if>
  <br>
  <c:set var = "salary" scope = "session" value = "${2000*2}"/>
  <c:if test = "${salary > 5000}">
  <p>My salary is:  <c:out value = "${salary}"/><p>
    </c:if>
  </body>
</html>
