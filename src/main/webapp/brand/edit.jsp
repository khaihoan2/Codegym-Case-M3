<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 10/5/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<div>
    <form action="/brands?action=edit&id=${id}" method="post">
        <button>Yes</button>
        <a type="button" href="/brand">No</a>
    </form>
</div>
</body>
</html>
