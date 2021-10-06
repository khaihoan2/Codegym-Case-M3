<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 10/3/2021
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/shipment?action=delete&id=${id}" method="post">
        <button>Yes</button>
        <a type="button" href="/shipment">No</a>
    </form>
</div>
</body>
</html>
