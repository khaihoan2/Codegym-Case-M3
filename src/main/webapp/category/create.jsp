<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>$</title>
</head>
<body>
<div class="container">
    <form action="/categories?action=create" method="post" class="card">
        <div class="card-header">
            <h3>Create form</h3>
        </div>
        <div class="card-body">
            <c:if test="${message != null}">
                <p>${message}</p>
            </c:if>
            <div class="mb-3">
                <label for="name"></label>
                <input type="text" id="name" name="name" placeholder="Category name...">
            </div>
            <div>
                <button>Submit</button>
            </div>
        </div>

    </form>
</div>
</body>
</html>