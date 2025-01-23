package model.state;

import model.Solicitare;

import java.time.LocalTime;

public class EchipajPeDrum implements AbstractState {
    private int timeAsteptare; //minute

    public EchipajPeDrum(int timeAsteptare) {
        this.timeAsteptare = timeAsteptare;
    }

    public int getTimeAsteptare() {
        return timeAsteptare;
    }

    public void setTimeAsteptare(int timeAsteptare) {
        this.timeAsteptare = timeAsteptare;
    }

    @Override
    public String preiaMesajSpecific() {
        return ("Echipajul este pe drum spre locatie.\n" +
                "Timpul estimat de asteptare este " + this.getTimeAsteptare());
    }
}
