package shop.servlet;

import org.eclipse.jetty.server.Server;
import shop.db.DBConnection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import java.sql.Connection;

public class WebServer {
    public void main() throws Exception {
        Connection connection = new DBConnection().getConnection();

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new ProductServlet(connection)), "/products");

        Server server = new Server(8080);
        server.setHandler(handler);

        server.start();
        server.join();

    }
}
