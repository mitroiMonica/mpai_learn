package seminar;

import seminar.decorator.Car;
import seminar.decorator.Vehicle;
import seminar.decorator.VehicleWithAlarm;
import seminar.decorator.VehicleWithSportSeats;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start();
        car.stop();

        VehicleWithAlarm carWithAlarm = new VehicleWithAlarm(car);
        carWithAlarm.activateAlarm();

        VehicleWithSportSeats carWithSportSeats = new VehicleWithSportSeats(car);
        carWithSportSeats.setSeatProducer("Recaro");
    }
}
