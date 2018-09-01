<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 26.08.2018
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>
    Welcome
</h3>

<ul>
    <li><a href="<c:url value="/dishes"/> ">Dishes list</a></li>
    <li><a href="<c:url value="/products"/> ">Products list</a></li>
    <li><a href="<c:url value="/clients"/> ">Clients list</a></li>
    <li><a href="<c:url value="/storages"/> ">Storages list</a></li>
</ul>
</body>
</html>
