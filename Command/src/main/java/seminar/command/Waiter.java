package seminar.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private List<FoodOrder> orders = new ArrayList<>();

    public void addOrder(FoodOrder order) {
        orders.add(order);
    }

    public void doOrders() {
        for (FoodOrder o : orders) {
            o.takeOrder();
        }
        orders.clear();
    }
}
