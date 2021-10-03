<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 10/3/2021
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            <c:forEach items="${shipments}" var="shipment">
                <tr>
                    <td>${shipment.id}</td>
                    <td>${shipment.name}</td>
                    <td><a href="/shipment?action=edit&id=${shipment.id}">Edit</a></td>
                    <td><a href="/shipment?action=delete&id=${shipment.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
