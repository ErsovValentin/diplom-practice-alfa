<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Валик
  Date: 17.09.2018
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <input type="checkbox" name="activity" readonly disabled
                           <c:if test="${!storage.activityOfProduct.name.equals(active.name)}">checked="checked"</c:if>
                    />
                </td>
                <td>${storage.storageProduct.name}</td>
                <td>${storage.storageClient.id}</td>
                <td><a href="<c:url value='/updateStorage/${storage.id}'/>">Update </a></td>
                <td><a href="<c:url value='/deleteStorage/${storage.id}'/>">Delete </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>



</body>
</html>
