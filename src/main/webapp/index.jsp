<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="user-servlet?action=register">Register</a>
<a href="user-servlet?action=login">login</a>
<h1>${userName}</h1>
<a href="user-servlet?action=logout">Logout</a>
</body>
</html>