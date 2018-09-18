<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Валик
  Date: 18.09.2018
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingredient</title>
</head>
<body>

<a href="<c:url value="/"/> ">Back to main menu</a>
<br/>
<br/>

<h1>Ingredients</h1>
<c:if test="${!empty listOfIngredients}">
    <table border="1">
        <tr>
            <td>Dish</td>
            <td>Product</td>
            <td>Quantity</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${listOfIngredients}" var="ingredient">
            <tr>
                <td>${ingredient.ingredientDish.name}</td>
                <td>${ingredient.ingredientProduct.name}</td>
                <td>${ingredient.quantity}</td>
                <td><a href="<c:url value='/updateIngredient/${ingredient.ingredientDish.id}/${ingredient.ingredientProduct.id}'/>">Update </a></td>
                <td><a href="<c:url value='/deleteIngredient/${ingredient.ingredientDish.id}/${ingredient.ingredientProduct.id}'/>">Delete </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add ingredient</h1>

<c:url var="addAction" value="/ingredients/addIngredient"/>
<form:form action="${addAction}" modelAttribute="ingredient">
    <table>
        <tr>
            <td>
                <form:label path="dishId">
                    <spring:message text="Dish"/>
                </form:label>
            </td>
            <td>
                <c:choose>
                    <c:when test="${ingredient.dishId != 0}">
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
                <form:label path="productId">
                    <spring:message text="Product"/>
                </form:label>
            </td>
            <td>
                <c:choose>
                    <c:when test="${ingredient.productId != 0}">
                        <form:input path="productId" readonly="true" disabled="true"/>
                        <form:hidden path="productId"/>
                    </c:when>
                    <c:otherwise>
                        <form:select path="productId">
                            <form:options items="${listOfProducts}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="quantity">
                    <spring:message text="Quantity of product"/>
                </form:label>
            </td>
            <td>
                <form:input path="quantity"/>
            </td>
        </tr>

        <tr>
            <td>
                <c:choose>
                    <c:when test="${ingredient.dishId == 0}">
                        <input type="submit" value="<spring:message text="Add ingredient"/> "/>
                    </c:when>
                    <c:otherwise>
                        <form:hidden path="indicatorUpdate" />
                        <input type="submit" value="<spring:message text="Update ingredient"/> "/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

    </table>

</form:form>



</body>
</html>
