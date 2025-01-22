package curs;

import curs.strategy.DrawCardStrategy;
import curs.strategy.PlayCardStrategy;
import curs.strategy.SinglePlayerGame;

public class Main {
    public static void main(String[] args) {
        SinglePlayerGame game = new SinglePlayerGame();
        game.setStrategy(new DrawCardStrategy());
        game.playRound();
        game.playRound();
        game.setStrategy(new PlayCardStrategy());
        game.playRound();
        game.setStrategy(() -> System.out.println("Paused game"));
        game.playRound();
    }
}
