<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form action="/products/edit" method="post">
        <input  name="id" value="${products.id}" readonly><br>
        <input name="name" value="${products.name}"><br>
        <input name="price" value="${products.price}"><br>
        <input name="img" value="${products.img}"><br>
        <button type="submit">Edit</button>
    </form>
</div>
</body>
</html>