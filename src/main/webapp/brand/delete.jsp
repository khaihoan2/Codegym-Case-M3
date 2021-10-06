<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/5/2021
  Time: 4:39 PM
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
    <form action="/brand?action=delete&id=${id}" method="post">
        <button>Yes</button>
        <a type="button" href="/brand">No</a>
    </form>
</div>
</body>
</html>
