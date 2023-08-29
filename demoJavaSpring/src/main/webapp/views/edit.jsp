<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 09/08/2023
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Edit Product</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
    }
    .container {
      max-width: 500px;
      margin: 0 auto;
      padding: 20px;
      background-color: white;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
      border-radius: 5px;
    }
    img {
      width: 100%;
      max-height: 300px;
      object-fit: cover;
    }
    form {
      display: flex;
      flex-direction: column;
    }
    label, input {
      margin-bottom: 10px;
    }
    button {
      padding: 10px;
      background-color: #007bff;
      color: white;
      border: none;
      cursor: pointer;
    }
  </style>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<div class="container">
  <div align="center">
    <h2>Edit Product</h2>
    <img src="${product.image}" alt="Product Image">
    <form action="/products/edit" method="post">
      <label>ID:</label>
      <input type="text" name="id" value="${product.id}" readonly>
      <label>Name:</label>
      <input type="text" name="name" value="${product.name}">
      <label>Price:</label>
      <input type="number" name="price" value="${product.price}">
      <label>Image URL:</label>
      <input type="text" name="image" value="${product.image}">
      <button type="submit">Edit</button>
    </form>
  </div>
</div>
</body>
</html>
