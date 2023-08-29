<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <a href="http://localhost:8080/products">HOME</a>
    <form action="http://localhost:8080/products/search" method="get">
        <input type="text" name="name" placeholder="Tìm kiếm theo tên...">
        <button type="submit" class="search-link" style="">Search</button>
    </form>

    <a href="http://localhost:8080/products/add">
        <submit>thêm sản phẩn</submit>
    </a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>img</th>
            <th>edit</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td><img src="${p.img}" width="250" height="300"></td>
                <td>
                    <a href="/products/edit?id=${p.id}" type="button" class="btn btn-warning">Edit</a>
                </td>
                <td>
                    <a href="/products/delete?id=${p.id}" type="button" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
