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
<div>
    <form action="/brands?action=q">
        <input type="text" name="name">
        <button>Search</button>
    </form>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${brands}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td><a href="/brand?action=view&id=${brand.id}">View</a></td>
                <td><a href="/brand?action=edit&id=${brand.id}">Edit</a></td>
                <td><a href="/brand?action=delete&id=${brand.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
