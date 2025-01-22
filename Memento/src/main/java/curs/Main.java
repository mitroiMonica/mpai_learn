package curs;

import curs.memento.Game;

public class Main {
    public static void main(String[] args) {
        Game game1 = new Game();
        System.out.println(game1);
        game1.play();
        game1.saveGame();
        System.out.println(game1);
        game1.play();
        System.out.println(game1);
        game1.undoPreviousMove();
        System.out.println(game1);

    }
}
