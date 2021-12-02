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

    private static String post = "insert into public.products(name, price, \"creationDate\") VALUES (?, ?, DEFAULT)";


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
                Timestamp creationDateFromDB = resultSet.getTimestamp("creationDate");
                LocalDateTime localDateTime = creationDateFromDB.toLocalDateTime();
                arrayProducts.add(new Product(id, name, price, localDateTime));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       arrayProducts.forEach(x -> x.toString());
        return arrayProducts;

    }
}
