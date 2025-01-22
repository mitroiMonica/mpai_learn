package seminar.decorator;

public class Car implements Vehicle {
    private String producer;
    private int power;

    @Override
    public void start() {
        System.out.println("The car started.");
    }

    @Override
    public void stop() {
        System.out.println("The car stopped.");
    }
}
