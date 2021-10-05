<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/10/2021
  Time: 9:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login?action=signup" method="post">
    <tr>
        <td><input type="text" name="username" placeholder="username"></td>
        <td><input type="text" name="password" placeholder="password"></td>
        <td><input type="text" name="first_name" placeholder="first_name"></td>
        <td><input type="text" name="last_name" placeholder="last_name"></td>
        <td><input type="text" name="address" placeholder="address"></td>
        <td><input type="text" name="telephone" placeholder="telephone"></td>
        <td><input type="text" name="email" placeholder="email"></td>
        <td><input type="text" name="created_at" placeholder="created_at"></td>
    </tr>
    <button>sign Up</button>
</form>
</body>
</html>
