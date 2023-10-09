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
<c:if test="${categoriesDetail.get(i).categoryID == idCategory}">
    <tr>
        <td>
            <h2>
                    ${categoriesDetail.get(i).name}
                    ${categoriesDetail.get(i).categoryID}
                    ${categories.get(i).name}
            </h2>
        </td>
    </tr>
</c:if>

    </c:forEach>
</table>
</body>
</html>
