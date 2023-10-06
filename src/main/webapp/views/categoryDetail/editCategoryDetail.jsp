<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/10/2023
  Time: 2:07 CH
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
        <legend>Category detail edit Form</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="categoryDetailName"></td>
            </tr>
            <tr>
                <td>categoryId:</td>
                <td><input type="text" name="categoryId" id="categoryDetailCategoryId"></td>
            </tr>
            <tr>
                <td>status:</td>
                <td><input type="text" name="role" id="categoryDetailRole"></td>
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
