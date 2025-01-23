package model;

import model.observer.Observer;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Client implements Observer, Serializable {
    @Serial
    private static final long serialVersionUID = 13L;
    private UUID id = UUID.randomUUID();
    private String nume;

    public Client(String nume) {
        this.nume = nume;
    }

    public UUID getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void primesteNotificare(String message) {
        System.out.println("Client " + this.nume + ": " + message);
    }
}
