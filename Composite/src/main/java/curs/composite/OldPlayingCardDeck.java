package curs.composite;

import java.util.ArrayList;
import java.util.List;

public class OldPlayingCardDeck implements SoldableItem {
    private List<SoldableItem> items = new ArrayList<>();

    @Override
    public double getPrice() {
        double price = 0;
        for (SoldableItem item : items) {
            price += item.getPrice();
        }
        return price;
    }

    @Override
    public void addItem(SoldableItem item) {
        items.add(item);
    }

    @Override
    public void deleteItem(SoldableItem item) {
        items.remove(item);
    }

    @Override
    public SoldableItem getChildItem(int id) {
        if (id >= 0 && id < items.size()) {
            return items.get(id);
        }
        throw new RuntimeException("Invalid id");
    }
}
