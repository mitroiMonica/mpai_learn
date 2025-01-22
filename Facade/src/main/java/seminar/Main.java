package seminar;

import seminar.facade.CarFacade;

public class Main {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();
        carFacade.start();
        carFacade.emergencyBrake();
    }
}
