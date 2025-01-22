package curs;

import curs.proxy.AbstractPlayingCard;
import curs.proxy.PlayingCard;
import curs.proxy.PlayingCardProxy;

public class Main {
    public static void main(String[] args) {
        AbstractPlayingCard playingCard = new PlayingCard();
        playingCard.playCard("3 diamond");
        playingCard.playCard("3 diamond");

        AbstractPlayingCard playingCard1 = new PlayingCardProxy(playingCard);
        playingCard1.playCard("3 diamond");
        playingCard1.playCard("3 diamond");
    }
}
