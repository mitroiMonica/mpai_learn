package curs;

import curs.command.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        OnlinePlayer onlinePlayer1 = new OnlinePlayer();
        OnlinePlayer onlinePlayer2 = new OnlinePlayer();
        OnlinePlayer onlinePlayer3 = new OnlinePlayer();

        game.playHand(new PlayCardCommand(onlinePlayer1));
        game.playHand(new PlayCardCommand(onlinePlayer2));
        game.playHand(new DrawCardCommand(onlinePlayer3));
        game.playRound();
    }
}
