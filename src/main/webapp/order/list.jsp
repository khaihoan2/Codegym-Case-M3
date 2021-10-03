<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 10/3/2021
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/order?action=q" method="get">
            <input type="text" name="name">
            <button>Search</button>
        </form>
        <button>
            <a href="/order?action=create">Create</a>
        </button>
        <table>
            <tr>
                <th>Id</th>
                <th>UserName</th>
                <th>Payment</th>
                <th>Shipment</th>
                <th>Status</th>
                <th>Date Create</th>
            </tr>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <th>${order.id}</th>
                    <th>${order.userName}</th>
                    <th>${order.paymentName}</th>
                    <th>${order.shipmentName}</th>
                    <th>${order.statusName}</th>
                    <th>${order.createAt}</th>
                    <th><a href="/order?action=edit&id=${order.id}">Edit</a></th>
                    <th><a href="/order?action=delete&id=${order.id}">Delete</a></th>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
