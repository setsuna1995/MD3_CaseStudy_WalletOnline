<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 10/5/2023
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view user</title>
</head>
<body>
<h1>view</h1>
<form method="post">
    <fieldset>
        <legend>Customer Form</legend>
        <td><input type="text" name="id" id="id" value="${user.userId}" hidden="hidden"></td>

        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" readonly value="${user.name}"></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName" id="userName" readonly value="${user.userName}"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password" id="password" readonly value="${user.password}"></td>
            </tr>
            <tr>
                <td>RePassword:</td>
                <td><input type="text" name="rePassword" id="rePassword" readonly value="${user.password}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" id="address" readonly value="${user.address}"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
