<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/10/2023
  Time: 4:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <th>UserName</th>
        <th>Address</th>
        <th>Status</th>
        <th>view</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${users}' var="user">
    <tr>
        <td>${user.name}</td>
        <td>${user.userName}</td>
        <td>${user.address}</td>
        <c:if test="${user.status == 1}">
            <td>Còn hàng</td>
        </c:if>
        <c:if test="${user.status == 0}">
            <td>Hết hàng</td>
        </c:if>
        <c:if test="${user.status == 2}">
            <td>Admin</td>
        </c:if>
        <td><a href="user-servlet?action=view&id=${user.userId}">View</a></td>
        <td><a href="user-servlet?action=edit&id=${user.userId}">Edit</a></td>
        <td><a href="user-servlet?action=delete&id=${user.userId}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
