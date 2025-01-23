package model.state;

public class OrderReady implements OrderState {
    @Override
    public String message() {
        return "Order is ready to be delivered!";
    }
}
