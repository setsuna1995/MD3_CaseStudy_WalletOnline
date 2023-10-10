<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 10/9/2023
  Time: 5:10 PM
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
        <th>UserName</th>
        <th>Category Detail Name</th>
        <th>Date</th>
        <th>Money</th>
        <th>Description</th>
        <th>view</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${moneyList}' var="money">
    <tr>
        <td>${money.user.userName}</td>
        <td>${money.categoryDetail.name}</td>
        <td>${money.date}</td>
        <td>${money.money}</td>
        <td>${money.description}</td>
        <td><a href="href="user-servlet?action=view&idUser=${money.user.id}&idCategoryDetail=${money.categoryDetail.id}">View</a></td>
        <td><a href="href="user-servlet?action=update&idUser=${money.user.id}&idCategoryDetail=${money.categoryDetail.id}">Update</a></td>
        <td><a href="href="user-servlet?action=delete&idUser=${money.user.id}&idCategoryDetail=${money.categoryDetail.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
