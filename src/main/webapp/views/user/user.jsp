<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 10/7/2023
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User</h1>
<p>
    <a href="/user-servlet">Back to customer list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>UserName: </td>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${user.address}</td>
    </tr>
    <tr>
        <td>Total Money: </td>
        <td>${user.totalMoney}</td>
    </tr>
    <tr>
        <td>Status: </td>
        <c:if test="${user.status == 1}">
            <td>Còn hàng</td>
        </c:if>
        <c:if test="${user.status == 0}">
            <td>Còn hàng</td>
        </c:if>
    </tr>
</table>
</body>
</html>
