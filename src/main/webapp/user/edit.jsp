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
<a href="/users"> Quay lại </a>
<table>
    <form method="post">
        <tr>
            <td><input type="text" name="username" value="${user.userName}"></td>
        </tr>

        <tr>
            <td><input type="text" name="password" value="${user.password}"></td>
        </tr>

        <tr>
            <td><input type=" text" name="firstname" value="${first_Name}"></td>
        </tr>

        <tr>
            <td><input type="text" name="lastname" value="${user.lastName}"></td>
        </tr>
        <tr>
            <td><input type="text" name="address" value="${user.address}"></td>
        </tr>
        <tr>
            <td><input type="number" name="telephone" value="${user.telephone}"></td>
        </tr>
        <tr>
            <td><input type="email" name="email" value="${user.email}"></td>
            <th>
                <button type="submit"> update</button>
            </th>
        </tr>

    </form>
</table>

</body>
</html>
