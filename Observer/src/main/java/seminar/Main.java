package seminar;

import seminar.observer.Observer;
import seminar.observer.YoutubeChannel;
import seminar.observer.YoutubeSubscriber;

public class Main {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel("MrBeast");
        Observer subscriber1 = new YoutubeSubscriber("Luca");
        Observer subscriber2 = new YoutubeSubscriber("Monica");

        channel.addSubcriber(subscriber1);
        channel.publishVideo();

        channel.addSubcriber(subscriber2);
        channel.publishVideo();
    }
}
