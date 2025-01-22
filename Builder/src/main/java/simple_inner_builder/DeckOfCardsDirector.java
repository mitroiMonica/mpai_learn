package simple_inner_builder;

public class DeckOfCardsDirector {
    private final AbstractDeckOfCardsBuilder builder;

    public DeckOfCardsDirector(AbstractDeckOfCardsBuilder builder) {
        this.builder = builder;
    }

    public DeckOfCards createDeck(float price, String model) {
        return builder.addPrice(price).addModel(model).build();
    }

    public DeckOfCards createDeck(float price, String model, String material) {
        return builder.addPrice(price).addModel(model).addMaterial(material).build();
    }
}
