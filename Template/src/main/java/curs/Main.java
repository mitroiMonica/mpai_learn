package curs;

import curs.template.GameOfCards;
import curs.template.War;

public class Main {
    public static void main(String[] args) {
        GameOfCards game = new War();
        game.playRound();
    }
}
