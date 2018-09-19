<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 19.09.2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favourite</title>
</head>
<body>

<a href="<c:url value="/"/> ">Back to main menu</a>
<br/>
<br/>

<h1>Ingredients</h1>
<c:if test="${!empty listOfFavourites}">
    <table border="1">
        <tr>
            <td>Favourite ID</td>
            <td>Dish</td>
            <td>Client</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${listOfFavourites}" var="favourite">
            <tr>
                <td>${favourite.id}</td>
                <td>${favourite.favouriteDish.name}</td>
                <td>${favourite.favouriteUser.id} | ${favourite.favouriteUser.firstName} ${favourite.favouriteUser.lastName}</td>
                <td><a href="<c:url value='/updateFavourite/${favourite.id}'/>">Update </a></td>
                <td><a href="<c:url value='/deleteFavourite/${favourite.id}'/>">Delete </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add ingredient</h1>

<c:url var="addAction" value="/favourites/addFavourite"/>
<form:form action="${addAction}" modelAttribute="favourite">
    <table>
        <c:if test="${favourite.dishId != 0}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text = "ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>

        <tr>
            <td>
                <form:label path="dishId">
                    <spring:message text="Dish"/>
                </form:label>
            </td>
            <td>
                <c:choose>
                    <c:when test="${favourite.dishId != 0}">
                        <form:input path="dishId" readonly="true" disabled="true"/>
                        <form:hidden path="dishId"/>
                    </c:when>
                    <c:otherwise>
                        <form:select path="dishId">
                            <form:options items="${listOfDishes}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="userId">
                    <spring:message text="Client"/>
                </form:label>
            </td>
            <td>
                <c:choose>
                    <c:when test="${favourite.userId != 0}">
                        <form:input path="userId" readonly="true" disabled="true"/>
                        <form:hidden path="userId"/>
                    </c:when>
                    <c:otherwise>
                        <form:select path="userId">
                            <c:forEach items="${listOfClients}" var="client">
                                <form:option value="${client.id}">${client.id} | ${client.firstName} ${client.lastName}</form:option>
                            </c:forEach>
                        </form:select>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <tr>
            <td>
                <c:choose>
                    <c:when test="${favourite.id == 0}">
                        <input type="submit" value="<spring:message text="Add favourite"/> "/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="<spring:message text="Update favourite"/> "/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>
