package controller;

import filter.SessionUser;
import model.Student;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean check = SessionUser.checkUser(request);
        if(check) {
        String action = request.getParameter("action");
        switch (action) {
            case "findAll":
                showAll(request, response);
                break;
            case "create":
                showFomAdd(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "edit":
                showFomEdit(request, response);
        }

    }
        else {
            response.sendRedirect("/user?action=login");
        }

    }


    private void showFomEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.studentService.delete(id);
        response.sendRedirect("/students?action=findAll");
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/home.jsp");
        dispatcher.forward(request, response);
    }

    public void showFomAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
        }
    }
    

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String image = request.getParameter("image");
        Student student = new Student(id, age, name, image);
        studentService.edit(id, student);
        response.sendRedirect("/students?action=findAll");
    }

    public void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String image = request.getParameter("image");
        Student student = new Student(id, age, name, image);
        studentService.add(student);
        response.sendRedirect("/students?action=findAll");
    }
}