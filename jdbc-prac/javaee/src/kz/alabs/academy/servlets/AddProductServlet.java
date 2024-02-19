package kz.alabs.academy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.alabs.academy.db.DBManager;
import kz.alabs.academy.entity.Product;
import kz.alabs.academy.entity.Student;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("productName");
        String description = req.getParameter("productDescription");
        LocalDate expiration_date = LocalDate.parse(req.getParameter("productExpirationDate"));
        Product product = new Product(name, description, expiration_date);

        DBManager.create(product);
        resp.sendRedirect("/home");
    }
}
