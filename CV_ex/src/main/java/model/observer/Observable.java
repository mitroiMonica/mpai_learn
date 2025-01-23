package model.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Observable {
    private Set<Observer> observers = new HashSet<>();

    public void abonare(Observer o) {
        this.observers.add(o);
    }

    public void dezabonare(Observer o) {
        this.observers.remove(o);
    }

    public void trimiteNotificatiTuturor(String message) {
        for (Observer o : observers) {
            o.primesteNotificare(message);
        }
    }
}
