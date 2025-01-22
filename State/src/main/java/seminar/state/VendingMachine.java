package seminar.state;

public class VendingMachine {
    private final int PRODUCT_PRICE = 15;
    private VendingMachineState state;
    private static double moneySent = 0;

    public VendingMachine() {
        this.state = new AcceptingMoneyState();
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void buyProduct(int money) {
        state.displayMessage();
        moneySent += money;
        if (moneySent >= PRODUCT_PRICE) {
            setState(new SelectingProductState());
            state.displayMessage();
            if (moneySent > PRODUCT_PRICE) {
                setState(new ReturningChangeState());
                state.displayMessage();
            }
            setState(new DeliveringProductState());
            state.displayMessage();
            moneySent = 0;
            setState(new AcceptingMoneyState());
        }
    }
}
