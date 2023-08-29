
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
    <link href="../css/index.css" type="text/css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg nav-bg">
                <a class="navbar-brand color-white" href="http://localhost:8080/student?action=home">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="http://localhost:8080/student?action=create">Create Staff <span
                                    class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
        <div class="col-12 mt-5">
            <table class="table">
                <form action="http://localhost:8080/student?action=create" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Name</label>
                            <input type="text" class="form-control" id="inputEmail4" name="name">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputPassword4">Salary</label>
                            <input type="text" class="form-control" id="inputPassword4" name="salary">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAddress">Email</label>
                        <input type="text" class="form-control" id="inputAddress" placeholder="" name="email">
                    </div>
                    <div class="form-group">
                        <label for="inputAddress2">Address</label>
                        <input type="text" class="form-control" id="inputAddress2" placeholder="" name="address">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputCity">PhoneNumber</label>
                            <input type="text" class="form-control" id="inputCity" name="phoneNumber">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="inputState">Department</label>
                            <select id="inputState" class="form-control" name="idDepartment">
                                <option value="1">Nhân sự</option>
                                <option value="2">Kế Toán</option>
                                <option value="3">Kế hoạch</option>
                            </select>
                            <%--                            <input type="text" class="form-control" id="classroom" name="idclassRoom">--%>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Create Staff</button>
                </form>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
<!