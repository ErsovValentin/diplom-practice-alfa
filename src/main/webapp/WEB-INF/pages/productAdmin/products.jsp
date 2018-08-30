<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 30.08.2018
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<a href="<c:url value="/"/> ">Back to main menu</a>
<br/>
<br/>


<h1>Products</h1>
<c:if test="${!empty listOfProducts}">
<table border="1">
    <tr>
    <td>ID</td>
    <td>Name</td>
    <td>Type</td>
    <td>Description</td>
    <td>Measure Unit</td>
    <td>Update</td>
    <td>Delete</td>
    </tr>

        <c:forEach items="${listOfProducts}" var="product">
    <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.type.name}</td>
            <td>${product.description}</td>
            <td>${product.measure.name}</td>
            <td><a href="<c:url value='/updateProduct/${product.id}'/>">Update </a></td>
            <td><a href="<c:url value='/deleteProduct/${product.id}'/>">Delete </a></td>
    </tr>
        </c:forEach>


</table>
</c:if>

<h1>Add a product</h1>
<c:url var="addAction" value="/product/addProduct"/>

<form:form action="${addAction}" modelAttribute="product">
    <table>
        <c:if test="${!empty product.name}">
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
                <form:select path="type">
                    <form:options items="${productType}" itemLabel="name"/>
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
                <form:label path="measure">
                    <spring:message text="Measure unit"/>
                </form:label>
            </td>
            <td>
                <form:select path="measure">
                    <form:options items="${productMeasure}" itemLabel="name"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>
                <c:if test="${empty product.name}">
                    <input type="submit" value="<spring:message text="Add product"/> "/>
                </c:if>
                <c:if test="${!empty product.name}">
                    <input type="submit" value="<spring:message text="Update product"/> "/>
                </c:if>
            </td>
        </tr>

    </table>
</form:form>



</body>
</html>
