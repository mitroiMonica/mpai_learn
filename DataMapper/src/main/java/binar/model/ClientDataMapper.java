package binar.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDataMapper {
    private static final File file = new File("clients.bin");

    public static void insert(Client c) {
        List<Client> clients = readFile();
        boolean exists = clients.stream().anyMatch(client -> client.getId() == c.getId());
        if (!exists) {
            clients.add(c);
            writeToFile(clients);
        } else {
            System.out.println("Client with ID " + c.getId() + " already exists.");
        }
    }

    public static void update(Client client) {
        List<Client> clients = readFile();
        for (Client c : clients) {
            if (c.getId() == client.getId()) {
                c.setName(client.getName());
            }
        }
        writeToFile(clients);
    }

    public static void delete(Client c) {
        List<Client> clients = readFile();
        clients.removeIf(client -> client.getId() == c.getId());
        writeToFile(clients);
    }

    private static void writeToFile(List<Client> clients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Client c : clients) {
                oos.writeObject(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Client> readFile() {
        List<Client> clients = new ArrayList<>();
        if (!file.exists()) {
            return clients;
        }
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Client c = (Client) oos.readObject();
                    clients.add(c);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }
}
