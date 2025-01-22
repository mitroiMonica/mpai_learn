package simple_inner_builder;

public class DeckOfCards {
    private float price;
    private float discount;
    private String producer;
    private String material;
    private float weight;
    private String model;

    private DeckOfCards() {
    }

    DeckOfCards(float price, float discount, String producer, String material, float weight, String model) {
        this.price = price;
        this.discount = discount;
        this.producer = producer;
        this.material = material;
        this.weight = weight;
        this.model = model;
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                "price=" + price +
                ", discount=" + discount +
                ", producer='" + producer + '\'' +
                ", material='" + material + '\'' +
                ", weight=" + weight +
                ", model='" + model + '\'' +
                '}';
    }

    public static class DeckBuilder implements AbstractDeckOfCardsBuilder {
        private DeckOfCards deckOfCards = new DeckOfCards();

        @Override
        public AbstractDeckOfCardsBuilder addPrice(float price) {
            deckOfCards.price = price;
            return this;
        }

        @Override
        public AbstractDeckOfCardsBuilder addDiscount(float discount) {
            deckOfCards.discount = discount;
            return this;
        }

        @Override
        public AbstractDeckOfCardsBuilder addProducer(String producer) {
            deckOfCards.producer = producer;
            return this;
        }

        @Override
        public AbstractDeckOfCardsBuilder addMaterial(String material) {
            deckOfCards.material = material;
            return this;
        }

        @Override
        public AbstractDeckOfCardsBuilder addWeight(float weight) {
            deckOfCards.weight = weight;
            return this;
        }

        @Override
        public AbstractDeckOfCardsBuilder addModel(String model) {
            deckOfCards.model = model;
            return this;
        }

        @Override
        public DeckOfCards build() {
//            DeckOfCards copy = new DeckOfCards();
//            copy.price = deckOfCards.price;
//            copy.discount = deckOfCards.discount;
//            copy.producer = deckOfCards.producer;
//            copy.material = deckOfCards.material;
//            copy.weight = deckOfCards.weight;
//            copy.model = deckOfCards.model;
//            deckOfCards = new DeckOfCards();
//            return copy;
            //sau dupa mine si mai simplu:
            DeckOfCards copy = deckOfCards;
            deckOfCards = new DeckOfCards();
            return copy;
        }
    }
}