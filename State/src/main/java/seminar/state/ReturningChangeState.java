package seminar.state;

public class ReturningChangeState implements VendingMachineState {
    @Override
    public void displayMessage() {
        System.out.println("Please pick your change!");
    }
}
