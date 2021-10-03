<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 10/3/2021
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div>
      <form action="/payment?action=delete&id=${id}" method="post">
          <button>Yes</button>
          <a type="button" href="/payment">No</a>
      </form>
  </div>
</body>
</html>
