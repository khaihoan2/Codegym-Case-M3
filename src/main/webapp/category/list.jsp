<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>$</title>
</head>
<body>


<a href="${pageContext.request.contextPath}/categories?action=create">Create new category</a>

<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>View</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td><a href="/categories?action=view&id=${category.id}">View</a></td>
            <td><a href="/categories?action=edit&id=${category.id}">Edit</a></td>
            <td><a href="/categories?action=delete&id=${category.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>