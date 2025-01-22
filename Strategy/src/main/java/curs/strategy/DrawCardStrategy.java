package curs.strategy;

public class DrawCardStrategy implements Strategy {
    @Override
    public void doAction() {
        System.out.println("Player has drawn card");
    }
}
