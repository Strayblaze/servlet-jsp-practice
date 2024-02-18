package kz.alabs.academy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/grading")
public class GradingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String fullName = req.getParameter("fullName");
        String eval = req.getParameter("eval");

        int score;
        try {
            score = Integer.parseInt(eval);
        } catch (NumberFormatException e) {
            out.println("<html>");
            out.println("<head><title>Error</title></head>");
            out.println("<body>");
            out.println("<h1>Error: Invalid score</h1>");
            out.println("<p>Exam score must be a valid integer.</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        String grade = calculateGrade(score);
        out.println("<html>");
        out.println("<head><title>Exam Grade</title></head>");
        out.println("<body>");
        out.println("<h1>Hello, " + fullName + "!</h1>");
        out.println("<p>Your score: " + score + "</p>");
        out.println("<p>Your grade: " + grade + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
    private String calculateGrade(int eval) {
        if (eval >= 90) {
            return "A";
        } else if (eval >= 75) {
            return "B";
        } else if (eval >= 60) {
            return "C";
        } else if (eval >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
