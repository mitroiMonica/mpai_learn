package seminar.state;

public class SelectingProductState implements VendingMachineState {
    @Override
    public void displayMessage() {
        System.out.println("Please select product!");
    }
}
