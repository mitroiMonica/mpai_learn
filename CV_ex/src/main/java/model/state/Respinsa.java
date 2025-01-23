package model.state;

import model.Solicitare;

public class Respinsa implements AbstractState {
    @Override
    public String preiaMesajSpecific() {
        return "Solicitarea nu a fost considerata urgenta!";
    }
}
