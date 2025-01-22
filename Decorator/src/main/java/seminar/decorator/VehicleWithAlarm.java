package seminar.decorator;

public class VehicleWithAlarm extends VehicleDecorator {
    public VehicleWithAlarm(Vehicle vehicle) {
        super(vehicle);
    }

    public void activateAlarm() {
        System.out.println("The alarm is on.");
    }

    @Override
    public void stop() {
        super.stop();
        activateAlarm();
    }
}
