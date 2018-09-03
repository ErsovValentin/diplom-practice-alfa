<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 01.09.2018
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Storage</title>
</head>
<body>
<a href="<c:url value="/"/> ">Back to main menu</a>
<br/>
<br/>

<h1>Storages</h1>
<c:if test="${!empty listOfStorages}">
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Quantity of product</td>
            <td>Activity</td>
            <td>Product</td>
            <td>User</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${listOfStorages}" var="storage">
            <tr>
                <td>${storage.id}</td>
                <td>${storage.quantityOfProduct}</td>

                <td>
                    <input type="checkbox" name="active" readonly disabled
                           <c:if test="${storage.activityOfProduct != active}">checked="checked"</c:if>
                    />
                </td>
                <td>${storage.storageProduct.name}</td>
                <td>${storage.storageUser.id}</td>
                <td><a href="<c:url value='/updateStorage/${storage.id}'/>">Update </a></td>
                <td><a href="<c:url value='/deleteStorage/${storage.id}'/>">Delete </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
