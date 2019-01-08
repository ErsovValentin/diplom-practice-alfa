<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 31.08.2018
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client</title>
</head>
<body>
<a href="<c:url value="/"/> ">Back to main menu</a>
<br/>
<br/>

<h1>Client list</h1>

<c:if test="${!empty listOfClients}">

    <table border="2">
        <tr>
            <td>ID</td>
            <td>First name</td>
            <td>Last name</td>
            <td>Date of birth</td>
            <td>Sex</td>
            <td>Login</td>
            <td>Password</td>
            <td>Role</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${listOfClients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.dateOfBirth}</td>
                <td>${client.sex.name}</td>
                <td>${client.login}</td>
                <td>${client.password}</td>
                <td>${client.role.name}</td>
                <td><a href="<c:url value='/updateClient/${client.id}'/>">Update </a></td>
                <td><a href="<c:url value='/deleteClient/${client.id}'/>">Delete </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add Client</h1>
<c:url var ="addAction" value="/clients/addClient"/>

<form:form action="${addAction}" modelAttribute="client" >
    <table>
        <c:if test="${!empty client.firstName}">
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
                <form:label path="firstName">
                    <spring:message text="First name"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>

        </tr>


        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="Last name"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>


        <tr>
            <td>
                <form:label path="dateOfBirth">
                    <spring:message text="Date of birth"/>
                </form:label>
            </td>
            <td>
                <fmt:formatDate var="myDate" value="${client.dateOfBirth}" type="date"/>
                <form:input path="dateOfBirth" type="date" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="sex">
                    <spring:message text="Sex"/>
                </form:label>
            </td>
            <td>
                <form:select path="sex">
                    <form:options items="${clientSex}" itemLabel="name"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="login">
                    <spring:message text="Login"/>
                </form:label>
            </td>
            <td>
                <c:if test="${empty client.login}">
                    <form:input path="login"/>
                </c:if>
                <c:if test="${!empty client.login}">
                    <form:input path="login" readonly="true" disabled="true"/>
                    <form:hidden path="login"/>
                </c:if>

            </td>
        </tr>


        <tr>
            <td>
                <form:label path="password">
                    <spring:message text="Password"/>
                </form:label>
            </td>
            <td>
                <c:if test="${empty client.firstName}">
                    <form:password path="password" showPassword="true"/>
                </c:if>
                <c:if test="${!empty client.firstName}">
                    <form:password path="password" showPassword="true" readonly="true" disabled="true" />
                    <form:hidden path="password"/>
                </c:if>

            </td>
        </tr>

        <tr>
            <td>
                <form:label path="role">
                    <spring:message text="Role"/>
                </form:label>
            </td>
            <td>
                <form:select path="role">
                    <form:options items="${clientRole}" itemLabel="name"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>
                <c:if test="${!empty client.firstName}">
                    <input type="submit"
                           value="<spring:message text="Update Client"/> "/>
                </c:if>
                <c:if test="${empty client.firstName}">
                    <input type="submit"
                           value="<spring:message text="Add Client"/> "/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
