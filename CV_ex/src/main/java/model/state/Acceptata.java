package model.state;

import model.Solicitare;

public class Acceptata implements AbstractState {
    @Override
    public String preiaMesajSpecific() {
        return "Solicitarea a fost considerata urgenta!";
    }
}
