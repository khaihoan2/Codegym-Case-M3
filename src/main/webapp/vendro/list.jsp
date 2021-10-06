<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/6/2021
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <button><a href="/vendors?action=create">create</a></button>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <c:forEach items="${vendro}" var="vendro">
            <tr>
                <td>${vendro.id}</td>
                <td>${vendro.name}</td>
                <td><a href="/vendro?action=view&id=${vendro.id}">View</a></td>
                <td><a href="/vendro?action=edit&id=${vendro.id}">Edit</a></td>
                <td><a href="/vendro?action=delete&id=${vendro.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
