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
    <%--@elvariable id="categoriesDetail" type="com.sun.java.accessibility.util.Translator"--%>
    <c:forEach var="i" begin="0" end="${categoriesDetail.size()-1}">

        <tr>
            <td>
                <h2>
                        ${categoriesDetail.get(i).name}
                        ${categoriesDetail.get(i).categoryID}
                        ${categories.get(i).name}
                </h2>
            </td>
            <td>
                <a href="category-detail-servlet?action=edit&id=${categoriesDetail.get(i).id}">edit</a>
            </td>
            <td>
                <a href="category-detail-servlet?action=delete&idDelete=${categoriesDetail.get(i).id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
