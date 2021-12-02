package shop.dao;

import shop.entyty.Product;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;

public class ProductDao {
    private final Connection connection;

    private static String selectAll = "select * from products";
    private static String select = "products";

    private static String post = "insert into products (name, price, creationDate) VALUES (?,?, ?)";


    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public void postProduct(String name, int price){
        try( PreparedStatement ps = connection.prepareStatement(post)) {
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setDate(3, Date.valueOf(LocalDateTime.now().toLocalDate()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Collection<Product> getProducts(){
        ArrayList<Product> arrayProducts = new ArrayList();

        try( PreparedStatement ps = connection.prepareStatement(selectAll)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Date creationDateFromDB = resultSet.getDate("creationDate");
                LocalDateTime creationDate = creationDateFromDB.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                arrayProducts.add(new Product(id, name, price, creationDate));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return arrayProducts;

    }
}
