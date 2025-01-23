package model.state;

public class Analiza implements AbstractState {
    @Override
    public String preiaMesajSpecific() {
        return "Solicitarea se afla in analiza!";
    }
}
