<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Add New Product</title>
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
</head>
<body>
<div class="container">
  <div align="center">
    <h2>Add New Product</h2>
    <form action="/products/add" method="post">
      <label>Name:</label>
      <input type="text" name="name" required>
      <label>Price:</label>
      <input type="number" name="price" step="0.01" required>
      <label>Image URL:</label>
      <input type="text" name="img" required>
      <button type="submit">Add Product</button>
    </form>
  </div>
</div>
</body>
</html>