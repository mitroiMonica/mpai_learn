package curs;

import curs.composite.OldPlayingCard;
import curs.composite.OldPlayingCardDeck;
import curs.composite.SoldableItem;

public class Main {
    public static void main(String[] args) {
        SoldableItem oldCardFromMagician = new OldPlayingCard(23);
        SoldableItem oldCardFromHoudini = new OldPlayingCard(55);
        SoldableItem deck = new OldPlayingCardDeck();
        deck.addItem(oldCardFromMagician);
        deck.addItem(oldCardFromHoudini);
        System.out.println(deck.getPrice());
    }
}
