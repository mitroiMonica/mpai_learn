package curs.adapter;

public class GameObjectAdapter implements AbstractNewGame {
    private final AbstractOldGame oldGame;

    public GameObjectAdapter(AbstractOldGame oldGame) {
        this.oldGame = oldGame;
    }

    @Override
    public void generateCard() {
        oldGame.drawCard();
    }
}
