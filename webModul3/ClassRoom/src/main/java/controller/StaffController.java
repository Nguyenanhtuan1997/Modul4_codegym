package controller;

import model.Department;
import model.Staff;
import service.StaffService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffController", value = "/student")
public class StaffController extends HttpServlet {
  private StaffService staffService = new StaffService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showHome(request,response);
                break;
            case "create":
                showFormCreate(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.delete(id);
        response.sendRedirect("/student?action=home");
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/home.jsp");
        List<Staff> staff = staffService.findAll();
        request.setAttribute("student", staff);
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createStudent(request,response);
                break;
            case "edit":
                editStudent(request,response);
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float salary = Float.parseFloat(request.getParameter("salary"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));
        Department department = new Department(idDepartment);
        Staff staff = new Staff(name,salary,email,address,phoneNumber,department);
        staffService.edit(id,staff);
        response.sendRedirect("http://localhost:8080/student?action=home");
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        float salary = Float.parseFloat(request.getParameter("salary"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        System.out.println(request.getParameter("idDepartment"));
        int idDepartment  = Integer.parseInt(request.getParameter("idDepartment"));
        Department department = new Department(idDepartment);
        Staff staff = new Staff(name,salary,email,address,phoneNumber,department);
        staffService.add(staff);
        response.sendRedirect("http://localhost:8080/student?action=home");
    }
}