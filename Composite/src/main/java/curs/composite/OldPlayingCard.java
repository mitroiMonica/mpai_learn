package curs.composite;

public class OldPlayingCard implements SoldableItem {
    private final double price;

    public OldPlayingCard(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void addItem(SoldableItem item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteItem(SoldableItem item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SoldableItem getChildItem(int id) {
        throw new UnsupportedOperationException();

    }
}
