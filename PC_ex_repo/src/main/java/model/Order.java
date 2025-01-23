package model;

import model.observer.Observable;
import model.state.OrderDelivered;
import model.state.OrderReady;
import model.state.OrderRegistered;
import model.state.OrderState;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class Order extends Observable implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    private final static Random random = new Random();
    private final UUID id;
    private List<Product> products;
    private Client client;
    private OrderState state;

    public Order(List<Product> products, Client client) {
        this.id = UUID.randomUUID();
        this.products = products;
        this.client = client;
        this.addObserver(this.client);
    }

    public Order(UUID id) {
        this.id = id;
        this.addObserver(this.client);
    }

    public UUID getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
        this.sendNotificationsToAll(this.state.message());
    }

    public void placeOrder() {
        try {
            this.setState(new OrderRegistered());

            Thread.sleep(random.nextInt(5000));
            this.setState(new OrderReady());

            Thread.sleep(random.nextInt(7000));
            this.setState(new OrderDelivered());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getOrderPrice() {
        double price = 0;
        for (Product p : products) {
            price += p.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
