package seminar.adapter;

public class ObjectAdapter implements AbstractTrainTicketingSystem {
    private AbstractBusTicketingSystem ticketingSystem;

    public ObjectAdapter(AbstractBusTicketingSystem ticketingSystem) {
        this.ticketingSystem = ticketingSystem;
    }

    @Override
    public void buyTicket(int wagonNo, int seatNo) {
        ticketingSystem.reserveSeat();
    }
}
