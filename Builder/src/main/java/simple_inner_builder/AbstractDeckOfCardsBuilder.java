package simple_inner_builder;

public interface AbstractDeckOfCardsBuilder {
    AbstractDeckOfCardsBuilder addPrice(float price);

    AbstractDeckOfCardsBuilder addDiscount(float discount);

    AbstractDeckOfCardsBuilder addProducer(String producer);

    AbstractDeckOfCardsBuilder addMaterial(String material);

    AbstractDeckOfCardsBuilder addWeight(float weight);

    AbstractDeckOfCardsBuilder addModel(String model);

    DeckOfCards build();
}
