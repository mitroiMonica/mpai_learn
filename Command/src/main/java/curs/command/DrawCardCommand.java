package curs.command;

public class DrawCardCommand implements Command {
    private OnlinePlayer onlinePlayer;

    public DrawCardCommand(OnlinePlayer onlinePlayer) {
        this.onlinePlayer = onlinePlayer;
    }

    @Override
    public void doAction() {
        onlinePlayer.drawCard();
    }
}
