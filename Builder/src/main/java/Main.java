import builder.DeckOfCards;
import builder.DeckOfCardsBuilder;
import inner_builder.FoodItem;

public class Main {
    public static void main(String[] args) {
        DeckOfCardsBuilder builder = new DeckOfCardsBuilder();
        builder.addPrice(40).addProducer("ACME").addMaterial("plastic");
        builder.addModel("bicycle");
        DeckOfCards deckOfCards = builder.build();
        System.out.println(deckOfCards);

        FoodItem.FoodItemBuilder foodItemBuilder = new FoodItem.FoodItemBuilder();
        foodItemBuilder.addName("unt");
        foodItemBuilder.addPrice(10);
        foodItemBuilder.addDiscount(5);

        FoodItem foodItem = foodItemBuilder.build();
        System.out.println(foodItem);
        foodItemBuilder.addPrice(12);
        System.out.println(foodItem);
        System.out.println(foodItemBuilder.build());
    }
}
