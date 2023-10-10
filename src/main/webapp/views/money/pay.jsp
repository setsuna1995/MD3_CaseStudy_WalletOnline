<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 10/9/2023
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Money</h1>

<form method="post">
    <fieldset>
        <legend>Login Form</legend>
        <table>
            <tr>
                <td>Money:</td>
                <td><input type="text" name="money" id="money"></td>
            </tr>

            <tr>
                <td>Category Detail:</td>
                <td>
                    <select name="categoryDetailID">
                        <c:forEach items="${categories}" var="categoryDetail">
                            <option value="${categoryDetail.id}">${categoryDetail.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Description:</td>
                <td>
                    <textarea name="description" rows="4" cols="50">
                    </textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<%--<table>--%>
<%--    <c:forEach var="categoryDetail" items="${categoriesDetail}">--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <h2>--%>
<%--                        ${categoryDetail.name}--%>
<%--                        ${categoryDetail.category.name}--%>
<%--                </h2>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="category-detail-servlet?action=edit&id=${categoryDetail.id}">edit</a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="category-detail-servlet?action=delete&idDelete=${categoryDetail.id}">delete</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
</body>
</html>
