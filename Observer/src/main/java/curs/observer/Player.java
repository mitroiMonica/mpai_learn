package curs.observer;

public class Player implements Observer {
    @Override
    public void sendNotification() {
        System.out.println("You can play your card now!");
    }
}
