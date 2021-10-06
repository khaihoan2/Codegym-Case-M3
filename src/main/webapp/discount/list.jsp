<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/6/2021
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--request--%>

<a href="${pageContext.request.contextPath}/discounts?action=create">Create new discount</a>

<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>View</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${discount}" var="discount">
        <tr>
            <td>${discount.id}</td>
            <td>${discount.name}</td>
            <td><a href="/discount?action=view&id=${discount.id}">View</a></td>
            <td><a href="/discount?action=edit&id=${discount.id}">Edit</a></td>
            <td><a href="/discount?action=delete&id=${discount.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
