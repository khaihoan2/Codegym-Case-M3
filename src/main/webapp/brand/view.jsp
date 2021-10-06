<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/6/2021
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/brands?action=view&id=${id}" method="post">
        <button>Yes</button>
        <a type="button" href="/brand">No</a>
    </form>
</div>
</body>
</html>
