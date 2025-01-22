package mvp;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final File file = new File("clients.bin");
    private static final Set<Client> clients = new HashSet<>();

    private int id;
    private String name;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String insert() {
        if (file.exists() && clients.isEmpty()) {
            readFromFile();
        }
        boolean wasNotAlready = clients.add(new Client(this.id, this.name));
        if (wasNotAlready) {
            writeToFile();
            return "Client successfully added!";
        } else {
            return "Client already existed!";
        }
    }

    public String update() {
        if (file.exists() && clients.isEmpty()) {
            readFromFile();
        }
        Client c = new Client(this.id, this.name);
        boolean wasNotAlready = clients.add(c);
        if (!wasNotAlready) {
            clients.remove(c);
            clients.add(c);
            writeToFile();
            return "Client successfully updated!";
        } else {
            return "Client does not exist!";
        }
    }

    public String delete() {
        if (file.exists() && clients.isEmpty()) {
            readFromFile();
        }
        Client c = new Client(this.id, this.name);
        boolean wasNotAlready = clients.add(c);
        if (!wasNotAlready) {
            clients.remove(c);
            writeToFile();
            return "Client successfully delete!";
        } else {
            return "Client already existed!";
        }
    }

    public static Set<Client> readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Client c = (Client) ois.readObject();
                    clients.add(c);
                } catch (EOFException e) {
                    break;
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

    private void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Client c : clients) {
                oos.writeObject(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
}
