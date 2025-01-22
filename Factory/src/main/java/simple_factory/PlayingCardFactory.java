package simple_factory;

public class PlayingCardFactory implements AbstractPlayingCardFactory {
    @Override
    public PlayingCard playCard(CardSuit suit) {
        return switch (suit) {
            case CLUB -> new ClubPlayingCard();
            case DIAMOND -> new DiamondPlayingCard();
            case HEART -> new HeartPlayingCard();
            case SPADE -> new SpadePlatingCard();
        };
    }
}
