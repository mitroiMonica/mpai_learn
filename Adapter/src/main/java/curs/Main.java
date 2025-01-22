package curs;

import curs.adapter.*;

public class Main {
    public static void main(String[] args) {
        AbstractNewGame newGame = new NewGame();
        newGame.generateCard();

        AbstractOldGame oldGame = new OldGame();
        newGame = new GameObjectAdapter(oldGame);
        newGame.generateCard();

        newGame = new GameClassAdapter();
        newGame.generateCard();
    }
}
