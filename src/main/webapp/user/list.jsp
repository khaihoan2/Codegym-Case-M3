<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2021
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px" bgcolor="#7fff00">
        <tr>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>first name</th>
            <th>last name</th>
            <th> address</th>
            <th>telephone</th>
            <th>email</th>
            <th>Ngày khởi tạo</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.address}</td>
                <td>${user.telephone}</td>
                <td>${user.email}</td>
                <td>${user.createAt}</td>
                <td>
                    <a href="users?action=update&id=${user.id}">update</a>
                    <a href="users?action=delete&id=${user.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="users?action=create">Create</a>
</form>

</body>
</html>
