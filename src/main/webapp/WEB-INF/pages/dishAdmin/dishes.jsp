<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 26.08.2018
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dishes</title>
</head>
<body>
<a href="<c:url value="/"/> ">Back to main menu</a>
<br/>
<br/>

<h1>Book list</h1>

<c:if test="${!empty listOfDishes}">

    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>Recepie</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${listOfDishes}" var="dish">
            <tr>
                <td>${dish.id}</td>
                <td>${dish.name}</td>
                <td>${dish.type.name}</td>
                <td>${dish.description}</td>
                <td>${dish.recepie}</td>
                <td><a href="<c:url value='/updateDish/${dish.id}'/>">Update </a></td>
                <td><a href="<c:url value='/deleteDish/${dish.id}'/>">Delete </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a dish</h1>
<c:url var ="addAction" value="/dishes/addDish"/>

<form:form action="${addAction}" modelAttribute="dish">
    <table>
        <c:if test="${!empty dish.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
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
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>

        </tr>


        <tr>
            <td>
                <form:label path="type">
                    <spring:message text="Type"/>
                </form:label>
            </td>
            <td>
                <form:select path="type" >
                    <form:options items="${dishTypes}"  itemLabel="name"/>
                </form:select>
            </td>
        </tr>




        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>

        </tr>

        <tr>
            <td>
                <form:label path="recepie">
                    <spring:message text="Recepie"/>
                </form:label>
            </td>
            <td>
                <form:input path="recepie"/>
            </td>

        </tr>

        <tr>
            <td>
                <c:if test="${!empty dish.name}">
                    <input type="submit"
                           value="<spring:message text="Update Dish"/> "/>
                </c:if>
                <c:if test="${empty dish.name}">
                    <input type="submit"
                           value="<spring:message text="Add Dish"/> "/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
