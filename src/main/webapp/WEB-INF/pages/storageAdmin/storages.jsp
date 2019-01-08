<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <input type="checkbox" name="activity" readonly disabled
                           <c:if test="${storage.activityOfProduct.name == 'Active'}">checked="checked"</c:if>
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

<h1>Add storage node</h1>

<c:url var="addAction" value="/storages/addStorage"/>

<form:form action="${addAction}" modelAttribute="storage">
<table>
        <c:if test="${storage.userId != 0}">
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
                <form:label path="userId">
                    <spring:message text="User"/>
                </form:label>
            </td>
            <td>
        <c:choose>
            <c:when test="${storage.userId != 0}">
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
                <form:label path="productId">
                    <spring:message text="Product"/>
                </form:label>
            </td>
            <td>
                <c:choose>
                    <c:when test="${storage.userId != 0}">
                        <form:input path="productId" readonly="true" disabled="true"/>
                        <form:hidden path="productId"/>

                    </c:when>
                    <c:otherwise>
                        <form:select path="productId">
                            <form:options items="${listOfProducts}"  itemLabel="name" itemValue="id"/>
                        </form:select>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>



        <tr>
            <td>
                <form:label path="quantityOfProduct">
                    <spring:message text="Quantity of product"/>
                </form:label>
            </td>
            <td>
                <form:input path="quantityOfProduct"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="activityOfProduct">
                    <spring:message text="Activity"/>
                </form:label>
            </td>


            <%--<spring:bind path="someForm.booleanFieldName">
                <input type=”hidden” name=”_<c:out value=”${status.expression}”/>” value=”visible” />
                <input type=”checkbox” name=”<c:out value=”${status.expression}”/>” value=”true” <c:if test=”${status.value}”>checked</c:if>>
            </spring:bind>--%>


            <td>
                <%--<form:select path="activityOfProduct">
                    <form:options items="${storageActivity}" itemLabel="name"/>
                </form:select>--%>
                <form:checkboxes path="activityOfProduct" items="${activity}" itemLabel="name"/>
            </td>
        </tr>


        <tr>
            <td>
                <c:choose>
                    <c:when test="${storage.userId == 0}">
                        <input type="submit" value="<spring:message text="Add storage node"/> "/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="<spring:message text="Update storage node"/> "/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

    </table>
</form:form>


</body>
</html>
