package curs;

import curs.observer.Player;
import curs.observer.PlayingCard;

public class Main {
    public static void main(String[] args) {
        PlayingCard playingCard = new PlayingCard("5H");
        Player player1 = new Player();
        Player player2 = new Player();
        playingCard.subscribe(player1);
        playingCard.subscribe(player2);
        playingCard.play();
        playingCard.unsubscribe(player1);
        playingCard.play();
    }
}
