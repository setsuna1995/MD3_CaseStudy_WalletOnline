<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/10/2023
  Time: 10:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Category detail Form</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="categoryDetailName" value="${categoryDetail.name}"></td>
            </tr>
            <tr>
                <td>Category Name:</td>
                <td><input type="text" name="categoryId" id="categoryDetailCategoryId" value="${categoryDetail.category.id}"></td>
            </tr>
            <tr>
                <td>Role:</td>
                <td><input type="text" name="role" id="categoryDetailRole" value="${categoryDetail.role}"></td>
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
</body>
</html>
