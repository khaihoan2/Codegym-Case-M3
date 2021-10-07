<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2021
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users?action=update" method="post">
    <input type="text"  name="id" placeholder="id">
    <input type="text"  name="username" placeholder="username">
    <input type="text" name="password" placeholder="password">
    <input type="text" name="firstname" placeholder="first_name">
    <input type="text" name="lastname" placeholder="last_name">
    <input type="text" name="address" placeholder="address">
    <input type="text" name="telephone" placeholder="telephone">
    <input type="text" name="email" placeholder="email">
    <button>update</button>
</form>
</body>
</html>
