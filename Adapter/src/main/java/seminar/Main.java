package seminar;

import seminar.adapter.*;

public class Main {
    public static void main(String[] args) {
        AbstractTrainTicketingSystem trainTicketingSystem = new TrainTicketingSystem();
        trainTicketingSystem.buyTicket(3, 6);

        AbstractBusTicketingSystem busTicketingSystem = new BusTicketingSystem();
        busTicketingSystem.reserveSeat();

        trainTicketingSystem = new ObjectAdapter(busTicketingSystem);
        trainTicketingSystem.buyTicket(5, 20);

        trainTicketingSystem = new ClassAdapter();
        trainTicketingSystem.buyTicket(100, 200);
    }
}
