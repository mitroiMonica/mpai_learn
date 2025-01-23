package model.state;

public class OrderDelivered implements OrderState {
    @Override
    public String message() {
        return "Order has been delivered!";
    }
}
