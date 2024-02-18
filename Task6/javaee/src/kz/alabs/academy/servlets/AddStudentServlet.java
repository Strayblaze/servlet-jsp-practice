package kz.alabs.academy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.alabs.academy.db.DBManager;
import kz.alabs.academy.entity.Student;

import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("studentName");
        String surname = req.getParameter("studentSurname");
        int age = Integer.parseInt(req.getParameter("studentAge"));
        String university = req.getParameter("studentUniversity");
        Student student = new Student(name, surname, age, university);

        DBManager.add(student);
        resp.sendRedirect("/students");
    }
}
