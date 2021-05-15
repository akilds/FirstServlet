<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14-05-2021
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Success Page</title>
</head>
<body>
<h3>Hii <%= request.getAttribute("user") %>, Login Successful. </h3>
<a href="login.html">Login Page</a>
</body>
</html>
