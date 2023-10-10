<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 10/6/2023
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${userName}</h1>
<a href="user-servlet?action=logout">Logout</a>
<br/>
<a href="money-servlet?action=collectMoney">Thu</a>
<a href="money-servlet?action=payMoney">Chi</a>
<a href="money-servlet?action=list">Lịch sử</a>
<a href="money-servlet?action=listCollectMoney">Danh sách Thu</a>
<a href="money-servlet?action=listPayMoney">Danh sách Chi</a>
</body>
</html>
