package kz.alabs.academy.db;

import kz.alabs.academy.entity.Product;
import kz.alabs.academy.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;
    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products?useUnicode=true&serverTimezone=UTC",
                    "postgres", "admin");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void create(Product product){
        try{
            PreparedStatement statement =
                    connection.prepareStatement("insert into products(name, description, expiration_date)"
                            + "values (?, ?, ?)");

            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDate(3, Date.valueOf(product.getExpiration_date()));

            statement.executeUpdate();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Product findById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from products where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return collectProduct(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Student not found");
    }

    public static void update(Product product){
        try{
            var updatedProduct = findById(product.getId());

            if (updatedProduct != null){
                PreparedStatement statement = connection.prepareStatement("update products set name = ?, description = ?, expiration_date = ? where id = ?");
                statement.setString(1, product.getName());
                statement.setString(2, product.getDescription());
                statement.setDate(3, Date.valueOf(product.getExpiration_date()));
                statement.setLong(4, product.getId());

                statement.executeUpdate();
                statement.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(Long id){
        try{
            if (findById(id) != null) {
                PreparedStatement statement = connection.prepareStatement("delete from products where id = ?");
                statement.setLong(1, id);
                statement.executeUpdate();
                statement.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        try{

            PreparedStatement statement =
                    connection.prepareStatement("select * from products");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                products.add(collectProduct(resultSet));
            }
            } catch (Exception e){
                e.printStackTrace();
            }
        return products;
    }

    public static void add(Student student){
    }
    private static Product collectProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setExpiration_date(resultSet.getDate(("expiration_date")).toLocalDate());
        return product;
    }
}
