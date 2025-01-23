import model.Client;
import model.Order;
import model.Product;
import model.repository.OrderRepository;
import presenter.Presenter;
import view.View;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Mascara", "For eyes", 21.99);
        Product p2 = new Product("Powder", "For every shade", 45.99);
        Product p3 = new Product("Eyeliner", "Intense black", 29.99);

        Client c1 = new Client("Maria");
        Order o1 = new Order(List.of(p1, p3), c1);
        System.out.println(o1.getOrderPrice());

        Client c2 = new Client("Ioana");
        Order o2 = new Order(List.of(p1), c2);

        Thread t1 = new Thread(o1::placeOrder);
        Thread t2 = new Thread(o2::placeOrder);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<Product> productsPredefined = Set.of(p1, p2, p3);
        Presenter presenter = new Presenter(new View(), new OrderRepository());
        presenter.start(productsPredefined, c1);
    }
}
