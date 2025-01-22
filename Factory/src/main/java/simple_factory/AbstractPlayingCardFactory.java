package simple_factory;

public interface AbstractPlayingCardFactory {
    PlayingCard playCard(CardSuit suit);
}
