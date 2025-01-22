package seminar.observer;

public class YoutubeSubscriber implements Observer {
    private String name;

    public YoutubeSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println(name + ": " + message);
    }
}
