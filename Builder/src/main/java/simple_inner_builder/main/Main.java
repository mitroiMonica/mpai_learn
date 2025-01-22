package simple_inner_builder.main;

import simple_inner_builder.DeckOfCards;
import simple_inner_builder.DeckOfCardsBuilder;
import simple_inner_builder.DeckOfCardsDirector;

public class Main {
    public static void main(String[] args) {
        DeckOfCardsBuilder builder = new DeckOfCardsBuilder();
        builder.addPrice(40).addProducer("ACME").addMaterial("plastic");
        builder.addModel("bicycle");
        DeckOfCards deckOfCards = builder.build();
        System.out.println(deckOfCards);

        DeckOfCards.DeckBuilder deckOfCardsBuilder = new DeckOfCards.DeckBuilder();
        deckOfCardsBuilder.addPrice(50);
        deckOfCardsBuilder.addProducer("ABCD").addModel("Kings");
        deckOfCardsBuilder.addMaterial("cardboard");
        DeckOfCards deckOfCards2 = deckOfCardsBuilder.build();
        System.out.println(deckOfCards2);
        deckOfCardsBuilder.addDiscount(50);
        System.out.println(deckOfCards2);

        DeckOfCardsDirector director =
                new DeckOfCardsDirector(new DeckOfCardsBuilder());
        DeckOfCards deckOfCards3 =
                director.createDeck(11, "XYZ");
        System.out.println(deckOfCards3);
    }
}
