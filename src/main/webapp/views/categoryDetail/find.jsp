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
        <%--@elvariable id="categories" type="java.util.List"--%>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>
                        ${category.name}
                </td>
                <td>
                    <a href="category-detail-servlet?action=showListCategoryDetail&id=${categoriesDetail.get(i).id}">edit</a>

                </td>
            </tr>

        </c:forEach>
</table>
</body>
</html>
