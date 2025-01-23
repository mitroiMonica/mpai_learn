package model.state;

public class OrderRegistered implements OrderState {
    @Override
    public String message() {
        return "Order has been registered!";
    }
}
