<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/5/2021
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<a href="/brands?action=create">Create</a>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Edit</th>
        <th>View</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${brand}" var="brand">
        <tr>
            <th>${brand.id}</th>
            <th>${brand.name}</th>
            <td><a href="/discount?action=view&id=${brand.id}">View</a></td>
            <th><a href="/brand?action=edit&id=${brand.id}">Edit</a></th>
            <th><a href="/brand?action=delete&id=${brand.id}">Delete</a></th>
        </tr>
    </c:forEach>
</table>
</table>
</body>
</html>
