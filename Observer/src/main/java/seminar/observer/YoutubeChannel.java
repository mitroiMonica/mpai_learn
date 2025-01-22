package seminar.observer;

public class YoutubeChannel extends Observable {
    private String name;

    public YoutubeChannel(String name) {
        this.name = name;
    }

    public void publishVideo() {
        super.sendNotificationsToAll("New video uploaded by " + this.name);
    }
}
