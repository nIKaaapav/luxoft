package shop.servise;

import shop.dao.ProductDao;
import shop.entyty.Product;

import java.sql.Connection;
import java.util.Collection;

public class ProductService {
    private final ProductDao productDAOSQL;

    public ProductService(Connection connection) {
        this.productDAOSQL = new ProductDao(connection);
    }

    public Collection<Product> getProducts(){
        return productDAOSQL.getProducts();
    }

    public void postProduct(String name, int price){
        productDAOSQL.postProduct(name, price);
    }
}
