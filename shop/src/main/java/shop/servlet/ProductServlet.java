package shop.servlet;

import shop.entyty.Product;
import shop.servise.ProductService;
import shop.templete.TemplateEngine;

import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
    private final TemplateEngine te = TemplateEngine.folder();
    final Connection connection;
    final ProductService service;

    public ProductServlet(Connection conn) {
        connection = conn;
        service = new ProductService(conn);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req.getRequestURL().toString());
//        if(req.getPathInfo().contains("/add")){
//            Map<String, Object> data = new HashMap<>();
//
//            data.put("products", "");
//
//            te.render("products_add.ftl", data, resp);
//        } else {
            Collection<Product> products = service.getProducts();
            Map<String, Object> data = new HashMap<>();

            data.put("products", products);
            System.out.println(products);

            te.render("/products.ftl", data, resp);
//        }
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
