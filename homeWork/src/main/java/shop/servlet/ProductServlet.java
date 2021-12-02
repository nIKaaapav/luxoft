package shop.servlet;

import shop.entyty.Product;
import shop.servise.ProductService;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
    final Connection connection;
    final ProductService service;

    public ProductServlet(Connection conn) {
        connection = conn;
        service = new ProductService(conn);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Collection<Product> products = service.getProducts();
        System.out.println(products);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String price = req.getParameter("price");

        Integer priceInteger = parseInt(price).get();

        service.postProduct(name, priceInteger);
    }

    private static int toInt (String s){
        return Integer.parseInt(s);
    }

    private static Optional<Integer> parseInt(String s){
        try{
            int value = toInt(s);
            return Optional.of(value);
        } catch (NumberFormatException x){
            return  Optional.empty();
        }
    }
}
