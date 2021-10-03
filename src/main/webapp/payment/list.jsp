<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 10/3/2021
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/payment?action=q" method="get">
            <input type="text" name="name">
            <button>Search</button>
        </form>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            <c:forEach items="${payments}" var="payment">
                <tr>
                    <th>${payment.id}</th>
                    <th>${payment.name}</th>
                    <th><a href="/payment?action=edit&id=${payment.id}">Edit</a></th>
                    <th><a href="/payment?action=delete&id=${payment.id}">Delete</a></th>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
