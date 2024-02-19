package kz.alabs.academy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.alabs.academy.db.DBManager;
import kz.alabs.academy.entity.Product;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("productId"));
        String name = req.getParameter("productName");
        String description = req.getParameter("productDescription");
        LocalDate expiration_date = LocalDate.parse(req.getParameter("productExpirationDate"));
        DBManager.update(new Product(id, name, description, expiration_date));
        resp.sendRedirect("/details?id=" + id);
    }
}
