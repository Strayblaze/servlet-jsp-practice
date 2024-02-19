package kz.alabs.academy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String fullName = req.getParameter("fullName");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");

        String greeting = generateGreeting(age, gender, fullName);
        out.println("<html>");
        out.println("<head><title>Greeting</title></head>");
        out.println("<body>");
        out.println("<h1>" + greeting + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
    private String generateGreeting(int age, String gender, String fullName) {
        String ageQualifier = (age >= 18) ? "Dear" : "Dude";
        String genderQualifier = (gender.equals("male")) ? "Mister" : "Miss";
        return "Hello " + ageQualifier + " " + genderQualifier + " " + fullName + "!";
    }
}
