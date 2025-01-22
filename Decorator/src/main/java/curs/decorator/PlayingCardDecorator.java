package curs.decorator;

public abstract class PlayingCardDecorator implements AbstractPlayingCard {
    private AbstractPlayingCard playingCard;

    public PlayingCardDecorator(AbstractPlayingCard playingCard) {
        this.playingCard = playingCard;
    }

    @Override
    public void play() {
        playingCard.play();
    }
}
