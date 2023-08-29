package app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ListStudent", value = "/ListStudent")
public class ListStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        Student student1 = new Student(1,"Hieu",12,"Ha Dong");
        Student student2 = new Student(2,"Tuan",27,"Ha Noi");
        students.add(student1);
        students.add(student2);

        response.setContentType("Text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        for (int i = 0; i < students.size(); i++) {
            writer.println("<h1>" + students.get(i) + "</h1>");
        }
        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}