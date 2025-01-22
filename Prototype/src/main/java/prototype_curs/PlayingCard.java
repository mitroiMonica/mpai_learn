package prototype_curs;

public abstract class PlayingCard implements Cloneable {
    protected int rank;
    protected char suit;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    @Override
    public PlayingCard clone() throws CloneNotSupportedException {
        return (PlayingCard) super.clone();
    }

    public abstract void render();
}
