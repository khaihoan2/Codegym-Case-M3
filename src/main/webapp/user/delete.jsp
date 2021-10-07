<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/7/2021
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

    <form action="/users?action=delete&id=${id}" method="post">
        <button>Yes</button>
        <a type="button" href="/users">No </a>

    </form>
</div>
</body>
</html>
