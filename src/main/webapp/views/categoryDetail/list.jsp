<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/10/2023
  Time: 9:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="category-detail-servlet?action=create">creat</a>
<a href="category-detail-servlet?action=find">find</a>
<table>
    <c:forEach var="categoryDetail" items="${categoriesDetail}">
        <tr>
            <td>
                <h2>
                        ${categoryDetail.name}
                        ${categoryDetail.category.name}
                </h2>
            </td>
            <td>
                <a href="category-detail-servlet?action=edit&id=${categoryDetail.id}">edit</a>
            </td>
            <td>
                <a href="category-detail-servlet?action=delete&idDelete=${categoryDetail.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
