package inner_builder;

import java.time.LocalDate;

public class FoodItem implements Cloneable {
    private String name;
    private float price;
    private String producer;
    private LocalDate bestBefore;
    private float discount;
    private boolean isVegan;

    private FoodItem() {
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                ", bestBefore=" + bestBefore +
                ", discount=" + discount +
                ", isVegan=" + isVegan +
                '}';
    }

    @Override
    public FoodItem clone() throws CloneNotSupportedException {
        FoodItem copy = (FoodItem) super.clone();
        copy.name = name;
        copy.price = price;
        copy.producer = producer;
        copy.bestBefore = bestBefore;
        copy.discount = discount;
        copy.isVegan = isVegan;
        return copy;
    }

    public static class FoodItemBuilder {
        private FoodItem foodItem = new FoodItem();

        public FoodItemBuilder addName(String name) {
            foodItem.name = name;
            return this;
        }

        public FoodItemBuilder addPrice(float price) {
            foodItem.price = price;
            return this;
        }

        public FoodItemBuilder addProducer(String producer) {
            foodItem.producer = producer;
            return this;
        }

        public FoodItemBuilder addDiscount(float discount) {
            foodItem.discount = discount;
            return this;
        }

        public FoodItemBuilder addBestBefore(LocalDate bestBefore) {
            foodItem.bestBefore = bestBefore;
            return this;
        }

        public FoodItemBuilder addIsVegan(boolean isVegan) {
            foodItem.isVegan = isVegan;
            return this;
        }

        public FoodItem build() {
            try {
                FoodItem copy = foodItem.clone();
                foodItem = new FoodItem();
                return copy;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}