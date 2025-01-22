package curs.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    protected void sendNotificationsToAll() {
        for (Observer observer : observers) {
            observer.sendNotification();
        }
    }
}
