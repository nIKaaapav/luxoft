package shop.entyty;

import java.time.LocalDateTime;

public class Product {
    private final int id;
    private final String name;
    private final int price;
    private final LocalDateTime creationDate;

    public Product(int id, String name, int price, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                '}';
    }
}
