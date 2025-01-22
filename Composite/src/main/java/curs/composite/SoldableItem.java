package curs.composite;

public interface SoldableItem {
    double getPrice();

    void addItem(SoldableItem item);

    void deleteItem(SoldableItem item);

    SoldableItem getChildItem(int id);
}
