<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/5/2021
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<a href="/Brand/create.jsp">Create</a>

<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${brands}" var="brand">
        <tr>
            <td>${brand.id}</td>
            <td>${brand.name}</td>
            <td><a href="/brand/edit.jsp">Edit</a></td>
            <td><a href="/brand/delete.jsp">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
