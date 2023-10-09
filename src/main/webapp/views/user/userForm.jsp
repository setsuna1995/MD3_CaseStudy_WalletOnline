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
    <title>Register Form</title>
</head>
<body>
    <h1>Register User</h1>

    <form method="post">
        <fieldset>
            <legend>Customer Form</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name" value="${user.name}"></td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="userName" id="userName" value="${user.userName}"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" id="password" value="${user.password}"></td>
                </tr>
                <tr>
                    <td>RePassword:</td>
                    <td><input type="text" name="rePassword" id="rePassword" value="${user.password}"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" id="address" value="${user.address}"></td>
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
