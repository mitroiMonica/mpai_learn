package curs;

import curs.flyweight.*;

public class Main {
    public static void main(String[] args) {
        SolitaireCardFactory factory = new SolitaireCardFactory();
        AbstractSolitairePlayingCard card1 = factory.getCard("AC");
        AbstractSolitairePlayingCard card2 = factory.getCard("2D");
        AbstractSolitairePlayingCard card3 = factory.getCard("AC");

        card1.display(1, 2);
        card2.display(3, 4);
        card3.display(7, 8);

        System.out.println(card1 == card3);
    }
}
