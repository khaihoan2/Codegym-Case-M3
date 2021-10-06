<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/5/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create</title>
</head>
<body>
<form action="/brands?action=create" method="post">
    <label for="name"></label>
    <input type="text" id="name" name="name" placeholder="Enter brand name...">
    <button>Create</button>
</form>
</body>
</html>
