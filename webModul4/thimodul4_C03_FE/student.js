function getAll() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/students",
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
getAll();

function show(arr) {
    let str = "";
    for (const s of arr) {
        str += ` <tr>
              <td>${s.id}</td>
              <td>${s.name}</td>
              <td>${s.dateofBirth}</td>
              <td>${s.address}</td>
              <td>${s.phoneNumber}</td>
              <td>${s.email}</td>
              <td>${s.classRoom.name}</td>
              <td><button type="button" class="btn btn-warning" onclick="showEdit(${s.id})" data-toggle="modal" data-target="#modalEdit" >Edit</button></td>
              <td><button type="button" class="btn btn-danger" onclick="deleteS(${s.id})" >Delete</button></td>
             </tr>`

    }
    document.getElementById("show").innerHTML = str;
}

function deleteS(idS){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/students/delete/"+idS,
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
        }
    });
}


function add() {
    let id = document.getElementById("idS").value;
    let name = document.getElementById("nameS").value;
    let dateofBirth = document.getElementById("dateofBirthS").value;
    let address = document.getElementById("addressS").value;
    let phoneNumber = document.getElementById("phoneNumberS").value;
    let email = document.getElementById("emailS").value;
    let idClassRoom = document.getElementById("idClassRoomS").value;
    let student = {id,name,dateofBirth,address,phoneNumber,email, classRoom:{id:idClassRoom}};

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/students",
        data: JSON.stringify(student),
        success: function (data) {
            getAll();
            resetInput();
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function resetInput() {
    let id = document.getElementById("idS").value="";
    let name = document.getElementById("nameS").value="";
    let dateofBirth = document.getElementById("dateofBirthS").value="";
    let address = document.getElementById("addressS").value="";
    let phoneNumber = document.getElementById("phoneNumberS").value="";
    let email = document.getElementById("emailS").value="";
    let idClassRoom = document.getElementById("idClassRoomS").value="";
    let student = {id,name,dateofBirth,address,phoneNumber,email, classRoom:{id:idClassRoom}};
}

function showEdit(idE){
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/students/"+idE,
        success: function (data) {
            document.getElementById("idE").value = data.id;
            document.getElementById("nameE").value = data.name;
            document.getElementById("dateofBirthE").value = data.dateofBirth;
            document.getElementById("addressE").value = data.address;
            document.getElementById("phoneNumberE").value = data.phoneNumber;
            document.getElementById("emailE").value = data.email;
            document.getElementById("idClassRoomE").value = data.classRoom.id;
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function edit() {
    let id = document.getElementById("idE").value;
    let name = document.getElementById("nameE").value;
    let dateofBirth = document.getElementById("dateofBirthE").value;
    let address = document.getElementById("addressE").value;
    let phoneNumber = document.getElementById("phoneNumberE").value;
    let email = document.getElementById("emailE").value;
    let idClassRoom = document.getElementById("idClassRoomE").value;
    let student = {id,name,dateofBirth,address,phoneNumber,email, classRoom:{id:idClassRoom}};

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/students",
        data: JSON.stringify(student),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function search(){
    let search = $("#search").val();
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/students/search?username="+ search,
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
        }
    });
}

let showClass = function (arr) {
    let str = '';
    for (const a of arr) {
        str += `<option value="${a.id}">${a.name}</option>`
    }
    document.getElementById("idClassRoomS").innerHTML = str;
    document.getElementById("idClassRoomE").innerHTML = str;
}


function getAllClass() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/class",
        success: function (data) {
            showClass(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
getAllClass();

