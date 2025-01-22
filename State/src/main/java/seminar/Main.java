package seminar;

import seminar.state.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.buyProduct(3);
        machine.buyProduct(13);
        machine.buyProduct(3);
    }
}
