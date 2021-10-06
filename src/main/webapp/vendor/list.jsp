<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/6/2021
  Time: 9:56 AM
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
<div>
    <button><a href="/vendors?action=create">create</a></button>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Edit</th>
            <th>View</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${vendors}" var="vendor">
            <tr>
                <td>${vendor.id}</td>
                <td>${vendor.name}</td>
                <td><a href="/vendor?action=view&id=${vendor.id}">View</a></td>
                <td><a href="/vendor?action=edit&id=${vendor.id}">Edit</a></td>
                <td><a href="/vendor?action=delete&id=${vendor.id}">Delete</a></td>
            </tr>


        </c:forEach>
    </table>
</div>
</body>
</html>
