package kz.alabs.academy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.alabs.academy.db.DBManager;
import kz.alabs.academy.entity.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        List<Student> students = DBManager.findAll();

        out.println("<html>");
        out.println("<head><title>Students</title></head>");
        out.println("<body>");
        out.println("<h1>Students</h1>");
        out.println("<ul>");

        for (Student student : students) {
            out.println("<li>" + student.getName() + " " + student.getSurname() + "</li>");
            out.println("<ul>");
            out.println("<li>Age: " + student.getAge() + "</li>");
            out.println("<li>University: " + student.getUniversity() + "</li>");
            out.println("</ul>");
        }

        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}
