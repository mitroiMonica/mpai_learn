package seminar.command;

public class Chef {
    public void bakePizza() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The pizza is ready.");
    }

    public void doBurger() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The burger is ready.");
    }
}
