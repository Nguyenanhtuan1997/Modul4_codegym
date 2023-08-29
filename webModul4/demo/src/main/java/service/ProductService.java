package service;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public ArrayList<Product> products;
    Connection connection = ConnectToMySQL.getConnection();

    public ProductService() {
        products = new ArrayList<>();
    }

    public Product findById(int id) {
        for (Product product:findAll()){
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int price = resultSet.getInt("price");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                products.add(new Product(id, price, name, img));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public void edit(Product product1) {
        String sql = "UPDATE product SET name = ?, price = ? , img = ? WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product1.getName());
            preparedStatement.setInt(2, product1.getPrice());
            preparedStatement.setString(3, product1.getImg());
            preparedStatement.setInt(4, product1.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "delete from product where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Product product) {
       String sql = "INSERT INTO product (name, price, img) VALUES (?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3,product.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     public List<Product> findByNameI(String name)  {
        List<Product> searchList = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                searchList.add(product);
            }
        }
        return searchList;
    }
}

