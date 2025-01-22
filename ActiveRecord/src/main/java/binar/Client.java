package binar;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private static final File file = new File("clients.bin");
    private int id;
    private String name;
    private LocalDate birthday;

    public Client(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void insert() {
        List<Client> clients = citireFisier();
        Client c = new Client(this.id, this.name, this.birthday);
        boolean exists = clients.stream().anyMatch(client -> client.getId() == c.getId());
        if (!exists) {
            clients.add(c);
            scriereFisier(clients);
        } else {
            System.out.println("Client with ID " + c.getId() + " already exists.");
        }
    }

    public void update(String name) {
        update(name, this.birthday);
    }

    public void update(String name, LocalDate birthday) {
        List<Client> clients = citireFisier();
        for (Client c : clients) {
            if (c.id == this.id) {
                c.name = name;
                c.birthday = birthday;
            }
        }
        scriereFisier(clients);
    }

    public void delete() {
        List<Client> clients = citireFisier();
        clients.removeIf(client -> client.getId() == this.id);
        scriereFisier(clients);
    }

    static void scriereFisier(List<Client> clients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Client c : clients) {
                oos.writeObject(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Client> citireFisier() {
        List<Client> clients = new ArrayList<>();
        if (!file.exists()) {
            return clients;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Client c = (Client) ois.readObject();
                    clients.add(c);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
