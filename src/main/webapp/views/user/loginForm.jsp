<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 10/5/2023
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<h1>Login User</h1>

<form method="post">
    <fieldset>
        <legend>Login Form</legend>
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName" id="userName"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password" id="password"></td>
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
