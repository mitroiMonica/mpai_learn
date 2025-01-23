package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private String title;
    private String description;
    private double price;

    public Product(String title, String description, double price) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
