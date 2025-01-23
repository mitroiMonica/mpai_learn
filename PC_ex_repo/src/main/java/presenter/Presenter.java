package presenter;

import model.Client;
import model.Order;
import model.Product;
import model.repository.AbstractOrderRepository;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Presenter {
    private final View view;
    private final AbstractOrderRepository repository;

    public Presenter(View view, AbstractOrderRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void start(Set<Product> productPredefined, Client client) {
        while (true) {
            try {
                int option = view.menu();
                if (option == 7) break;
                switch (option) {
                    case 1:
                        addOrder(productPredefined, client);
                        break;
                    case 2:
                        updateOrder(productPredefined, client);
                        break;
                    case 3:
                        deleteOrder();
                        break;
                    case 4:
                        getOrders();
                        break;
                    case 5:
                        filterByClient();
                        break;
                    case 6:
                        filterByNumber();
                        break;
                    default:
                        view.showMessage("Invalid Option!");
                }
            } catch (Exception e) {
                view.showMessage("Something went wrong!");
            }
        }
    }

    private void addOrder(Set<Product> productPredefined, Client client) {
        view.showMessage("Products:");
        view.showProduct(productPredefined);
        List<Product> productList = new ArrayList<>();
        while (true) {
            int option = view.productMenu();
            if (option == 2) break;
            else if (option == 1) {
                UUID id = view.readId("Product");
                if (productPredefined.stream().map(Product::getId).anyMatch(uuid -> uuid.equals(id))) {
                    productList.add(productPredefined.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null));
                } else {
                    view.showMessage("Product does not exists!");
                }
            } else {
                view.showMessage("Invalid option!");
            }
        }
        Order o = new Order(productList, client);
        if (productList.isEmpty()) {
            view.showMessage("Empty order!");
        } else {
            view.showMessage(repository.insert(o));
        }
    }

    private void updateOrder(Set<Product> productPredefined, Client client) {
        UUID id = view.readId("Order");
        Set<Order> orders = repository.readFromFile();
        if (orders.stream().map(Order::getId).anyMatch(uuid -> uuid.equals(id))) {
            view.showMessage("Products:");
            view.showProduct(productPredefined);
            List<Product> productList = new ArrayList<>();
            while (true) {
                int option = view.productMenu();
                if (option == 2) break;
                else if (option == 1) {
                    UUID productId = view.readId("Product");
                    if (productPredefined.stream().map(Product::getId).anyMatch(uuid -> uuid.equals(productId))) {
                        productList.add(productPredefined.stream().filter(p -> p.getId().equals(productId)).findFirst().orElse(null));
                    } else {
                        view.showMessage("Product does not exists!");
                    }
                } else {
                    view.showMessage("Invalid option!");
                }
            }
            Order o = new Order(id);
            o.setProducts(productList);
            o.setClient(client);
            if (productList.isEmpty()) {
                view.showMessage("Empty order! Invalid request!");
            } else {
                view.showMessage(repository.update(o));
            }
        } else {
            view.showMessage("Order does not exists!");
        }
    }


    private void deleteOrder() {
        UUID id = view.readId("Order");
        Set<Order> orders = repository.readFromFile();
        if (orders.stream().map(Order::getId).anyMatch(uuid -> uuid.equals(id))) {
            view.showMessage(repository.delete(id));
        } else {
            view.showMessage("Order does not exists!");
        }
    }

    private void getOrders() {
        for (Order o : repository.readFromFile()) {
            view.showMessage(o.toString());
        }
    }

    private void filterByClient() {
        UUID id = view.readId("Client");
        Set<Order> orders = repository.filterByClient(new Client(id));
        for (Order o : orders) {
            view.showMessage(o.toString());
        }
    }

    private void filterByNumber() {
        int number = view.readNumber();
        Set<Order> orders = repository.filterByNOProducts(number);
        for (Order o : orders) {
            view.showMessage(o.toString());
        }
    }
}
