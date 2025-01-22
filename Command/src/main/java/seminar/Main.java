package seminar;

import seminar.command.BurgerOrder;
import seminar.command.Chef;
import seminar.command.PizzaOrder;
import seminar.command.Waiter;

public class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Chef chef = new Chef();
        waiter.addOrder(new PizzaOrder(chef));
        waiter.addOrder(new PizzaOrder(chef));
        waiter.addOrder(new BurgerOrder(chef));
        waiter.doOrders();
    }
}
