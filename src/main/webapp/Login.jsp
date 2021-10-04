<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2021
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login?action=login" method="post">
  <input type="text" name="username">
  <input type="text" name="password">
  <button>Sign in</button>
</form>
<button><a href="/signup.jsp">sign up</a></button>
</body>
</html>
