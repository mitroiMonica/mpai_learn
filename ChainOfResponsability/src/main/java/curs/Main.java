package curs;

import curs.chain.AbstractPlayer;
import curs.chain.Player;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        player1.setCardToBePlayed("7C");
        Player player2 = new Player();
        player2.setCardToBePlayed("8D");
        Player player3 = new Player();
        player3.setCardToBePlayed("QD");

        player1.setNextPlayer(player2);
        player2.setNextPlayer(player3);
        player1.playCard("QS");

    }
}
