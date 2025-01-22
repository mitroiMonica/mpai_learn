package curs.strategy;

public class PlayCardStrategy implements Strategy {
    @Override
    public void doAction() {
        System.out.println("Card has been played");
    }
}
