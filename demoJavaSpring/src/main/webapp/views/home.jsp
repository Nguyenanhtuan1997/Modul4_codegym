<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 09/08/2023
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
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
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #252585;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
        }

        header h1 {
            font-size: 24px;
            margin: 0;
        }

        header a img {
            width: 35px;
            height: 35px;
            margin: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #252585;
            color: #fff;
        }

        img {
            width: 80px;
            height: 120px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        a {
            text-decoration: none;
            color: #252585;
        }

        a:hover {
            color: #b80000;
        }

        .add-button {
            display: inline-block;
            background-color: #b80000;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            margin-top: 10px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .add-button:hover {
            background-color: #f44336;
        }

        /* Style for the font-awesome icons */
        .fa {
            margin-right: 5px;
        }

        /* Style for the "Edit" and "Delete" links */
        .edit-link, .delete-link {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 3px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: #252585;
            transition: background-color 0.3s ease;
        }

        .edit-link:hover, .delete-link:hover {
            background-color: #4a4a9e;
        }

        /* Add spacing between "Edit" and "Delete" links */
        .edit-link {
            margin-right: 5px;
        }
        .add-link, .logout-link {
            display: inline-block;
            color: #fff;
            text-decoration: none;
            transition: opacity 0.3s ease;
        }

        .add-link .fa, .logout-link .fa {
            margin-right: 5px;
        }

        .add-link:hover, .logout-link:hover {
            opacity: 1;
        }
        /* Style for the "Search" link */
        .search-link {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 3px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: #252585;
            transition: background-color 0.3s ease;
        }

        .search-link:hover {
            background-color: #4a4a9e;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Product List</h2>
    <form action="http://localhost:8080/products/search" method="get">
        <input type="hidden" name="search" value="search">
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
        <c:forEach items="${products}" var="products">
            <tr>
                <td>${products.id}</td>
                <td>${products.name}</td>
                <td>${products.price}</td>
                <td><img src="${products.image}" width="250" height="300"></td>
                <td>
                    <a href="/products/edit?id=${products.id}" type="button" class="btn btn-warning">Edit</a>
                </td>
                <td>
                    <a href="/products/delete?id=${products.id}" type="button" class="btn btn-warning">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>