<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 10/3/2021
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/order?action=create&userId=${userId}" method="get">
    <input type="text" name="productId" placeholder="ProductId">
    <select name="paymentId">
        <c:forEach items="${payments}" var="payment">
            <option value="${payment.id}">${payment.name}</option>
        </c:forEach>
    </select>
    <select name="shipmentId">
        <c:forEach items="${shipments}" var="shipment">
            <option value="${shipment.id}">${shipment.name}</option>
        </c:forEach>
    </select>
    <input type="text" name="quantity">
    <button>Create</button>
</form>

</body>
</html>
