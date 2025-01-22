package curs.adapter;

public class GameClassAdapter extends OldGame implements AbstractNewGame {
    @Override
    public void generateCard() {
        super.drawCard();
    }
}
