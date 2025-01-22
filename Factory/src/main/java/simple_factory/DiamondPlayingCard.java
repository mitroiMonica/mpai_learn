package simple_factory;

public class DiamondPlayingCard extends PlayingCard {
    DiamondPlayingCard() {
    }

    @Override
    public String toString() {
        return getRank() + "D";
    }
}
