package seminar.adapter;

public class ClassAdapter extends BusTicketingSystem implements AbstractTrainTicketingSystem {
    @Override
    public void buyTicket(int wagonNo, int seatNo) {
        super.reserveSeat();
    }
}
