package model;

import model.observer.Observable;
import model.state.AbstractState;
import model.state.Analiza;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

//Active record as well:
public class Solicitare extends Observable implements Serializable {
    private static final File file = new File("solicitari.bin");
    private static final Set<Solicitare> solicitariFisier = new HashSet<>();
    @Serial
    private static final long serialVersionUID = 12L;

    private UUID id = UUID.randomUUID();
    private String descriere;
    private String locatie;
    transient private AbstractState state;
    private Client client;

    public Solicitare(String descriere, String locatie, Client client) {
        this.descriere = descriere;
        this.locatie = locatie;
        this.client = client;
        super.abonare(this.client);
        this.state = new Analiza();
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Solicitare{" +
                "id='" + id + '\'' +
                "descriere='" + descriere + '\'' +
                ", locatie='" + locatie + '\'' +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitare that = (Solicitare) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String insert() {
        if (file.exists() && solicitariFisier.isEmpty()) {
            getFromFile();
        }
        if (solicitariFisier.contains(this)) {
            return "Solicitare deja existenta!";
        } else {
            solicitariFisier.add(this);
            writeTofile();
            return "Solicitare adaugata cu succes!";
        }
    }

    public String delete() {
        if (file.exists() && solicitariFisier.isEmpty()) {
            getFromFile();
        }
        if (!solicitariFisier.contains(this)) {
            return "Solicitare inexistenta in fisier!";
        } else {
            solicitariFisier.remove(this);
            writeTofile();
            return "Solicitare stearsa cu succes!";
        }
    }

    public String update() {
        if (file.exists() && solicitariFisier.isEmpty()) {
            getFromFile();
        }
        if (!solicitariFisier.contains(this)) {
            return "Solicitare inexistenta in fisier!";
        } else {
            solicitariFisier.remove(this);
            solicitariFisier.add(this);
            writeTofile();
            return "Solicitare modificata cu succes!";
        }
    }

    public static Set<Solicitare> getFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Solicitare s = (Solicitare) ois.readObject();
                    solicitariFisier.add(s);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return solicitariFisier;
    }

    private void writeTofile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Solicitare s : solicitariFisier) {
                oos.writeObject(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
