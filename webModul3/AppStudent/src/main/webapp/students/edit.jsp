
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="http://localhost:8080/students?action=edit" method="post">
    <input type="text" name="id" placeholder="Id"> <br> <br>
    <input type="text" name="name" placeholder="Name"> <br> <br>
    <input type="text" name="age" placeholder="Age" > <br> <br>
    <input type="text" name="image" placeholder="Image"> <br> <br>
    <button>Sửa đổi</button>
</form>
</body>
</html>
