<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/6/2023
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h1>Category</h1>--%>
<%--<a href="/category-servlet?act=delete">Delete</a>--%>
<%--<c:forEach var="cate" items="${cat}">--%>
<%--    <h2>${cate.categoryId}, ${cate.categoryName}</h2>--%>
<%--</c:forEach>--%>

<center>
    <h1>Category</h1>
<%--    <h2>--%>
<%--        <a href="/users?action=create">Add New User</a>--%>
<%--    </h2>--%>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Category</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="cate" items="${cat}">
            <tr>
                <td><c:out value="${cate.categoryId}"/></td>
                <td><c:out value="${cate.categoryName}"/></td>
                <td>
<%--                    <a href="/users?action=edit&id=${cate.categoryId}">Edit</a>--%>
                    <a href="${pageContext.request.contextPath}/category-servlet?action=delete&id=${cate.categoryId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
