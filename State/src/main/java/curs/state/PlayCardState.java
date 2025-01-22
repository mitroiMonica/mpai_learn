package curs.state;

public class PlayCardState implements ComputerPlayerState {
    @Override
    public void play(int value) {
        System.out.println("Playing card with value " + value);
    }
}
