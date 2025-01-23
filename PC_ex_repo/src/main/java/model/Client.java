package model;

import model.observer.Observer;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class Client implements Observer, Serializable {
    @Serial
    private static final long serialVersionUID = 3L;

    private final UUID id;
    private String name;

    public Client(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Client(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println(this.name + ": " + message);
    }
}
