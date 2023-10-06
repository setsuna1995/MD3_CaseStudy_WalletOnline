<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/10/2023
  Time: 1:05 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="category-servlet?action=create">login</a>
<c:forEach var="category" items="${categories}">
  <h2>
      ${category.name}
  </h2>
        <a href="/category-detail-servlet?action=find&categoryID=${category.categoryID}">find</a>
</c:forEach>
</body>
</html>
