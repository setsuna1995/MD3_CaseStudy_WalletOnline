<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 10/6/2023
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${userName}</h1>
<a href="user-servlet?action=logout">Logout</a>
<a href="money-servlet?action=pay">Chi</a>
<a href="money-servlet?action=collectMoney">Thu</a>
</body>
</html>
