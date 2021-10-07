<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2021
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users?action=create" method="post">
    <table>
        <tr>
            <td>username</td>
            <td>
                <input type="text" name="userName">
            </td>
        </tr>
        <tr>
            <td>password</td>
            <td>
                <input type="text" name="password">
            </td>
        </tr> <tr>
            <td>firstname</td>
            <td>
                <input type="text" name="firstName">
            </td>
        </tr>
        <tr>
            <td>lastname</td>
            <td>
                <input type="text" name="lastName">
            </td>
        </tr>
        <tr>
            <td>address</td>
            <td>
                <input type="text" name="address">
            </td>
        </tr> <tr>
            <td>telephone</td>
            <td>
                <input type="text" name="telephone">
            </td>
        </tr> <tr>
            <td>email</td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td> <button type="submit">Update</button> </td>
        </tr>
    </table>
</form>
</body>
</html>
