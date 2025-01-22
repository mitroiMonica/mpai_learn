package seminar.decorator;

public class VehicleWithSportSeats extends VehicleDecorator {
    private String seatProducer;

    public VehicleWithSportSeats(Vehicle vehicle) {
        super(vehicle);
    }

    public String getSeatProducer() {
        return seatProducer;
    }

    public void setSeatProducer(String seatProducer) {
        this.seatProducer = seatProducer;
    }
}
