package simple_inner_builder;

public class DeckOfCardsBuilder implements AbstractDeckOfCardsBuilder {
    private float price;
    private float discount;
    private String producer;
    private String material;
    private float weight;
    private String model;

    @Override
    public AbstractDeckOfCardsBuilder addPrice(float price) {
        this.price = price;
        return this;
    }

    @Override
    public AbstractDeckOfCardsBuilder addDiscount(float discount) {
        this.discount = discount;
        return this;
    }

    @Override
    public AbstractDeckOfCardsBuilder addProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @Override
    public AbstractDeckOfCardsBuilder addMaterial(String material) {
        this.material = material;
        return this;
    }

    @Override
    public AbstractDeckOfCardsBuilder addWeight(float weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public AbstractDeckOfCardsBuilder addModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public DeckOfCards build() {
        return new DeckOfCards(price, discount, producer, material, weight, model);
    }

}
