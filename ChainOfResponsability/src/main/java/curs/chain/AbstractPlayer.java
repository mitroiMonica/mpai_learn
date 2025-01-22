package curs.chain;

public abstract class AbstractPlayer {
    protected AbstractPlayer nextPlayer = null;

    public void setNextPlayer(AbstractPlayer nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public abstract void playCard(String currentCard);
}
