<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/10/2021
  Time: 9:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>
<form action="/login?action=login" method="post">
    <input type="text" name="username">
    <input type="text" name="password">
    <button>Sing in</button>
</form>
<button><a href="/login/signup.jsp">signup</a></button>
</body>
</html>
