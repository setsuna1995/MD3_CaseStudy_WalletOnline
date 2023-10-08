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
<h1>Users</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>userName</th>
        <th>address</th>
        <th>totalMoney</th>
        <th>view</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${users}' var="item">
    <tr>
        <td>${item.getUserId()}</td>
        <td>${item.getName()}</td>
        <td>${item.getUserName()}</td>
        <td>${item.getAddress()}</td>
        <td>${item.getTotalMoney()}</td>
        <td><a href="user-servlet?action=view&userName=${item.userName}">View</a></td>
        <td><a href="user-servlet?action=edit&userName=${item.userName}">Edit</a></td>
        <td><a href="user-servlet?action=delete&id=${item.getUserId()}">Delete</a></td>
    </tr>
    </c:forEach>
</body>
</html>
