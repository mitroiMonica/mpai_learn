package text.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDataMapper {
    private static final File file = new File("clients.txt");

    public static void save(Client c) {
        List<Client> clients = readFile();
        boolean exists = clients.stream().anyMatch(client -> client.getId() == c.getId());
        if (!exists) {
            clients.add(c);
            writeToFile(clients);
        } else {
            System.out.println("Client with ID " + c.getId() + " already exists.");
        }
    }

    public static void delete(Client c) {
        List<Client> clients = readFile();
        clients.removeIf(client -> client.getId() == c.getId());
        writeToFile(clients);
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

    private static void writeToFile(List<Client> clients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Client c : clients) {
                writer.write(c.getId() + "," + c.getName());
                writer.newLine();
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
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                int id = Integer.parseInt(items[0]);
                String name = items[1];
                clients.add(new Client(id, name));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }
}
