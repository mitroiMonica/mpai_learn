package seminar.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addSubcriber(Observer observer) {
        observers.add(observer);
    }

    public void removeSubcriber(Observer observer) {
        observers.remove(observer);
    }

    protected void sendNotificationsToAll(String message) {
        for (Observer o : observers) {
            o.receiveNotification(message);
        }
    }
}
