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
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.id}</td>
            <td>${users.userName}</td>
            <td>${users.password}</td>
            <td>${users.firstName}</td>
            <td>${users.lastName}</td>
            <td>${users.address}</td>
            <td>${users.telephone}</td>
            <td>${users.email}</td>
            <td>${users.createAt}</td>
            <td>
               <a href="">update</a>
               <a href="/users?delete?sid=${users.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="create1.jsp">Create</a>
</body>
</html>
