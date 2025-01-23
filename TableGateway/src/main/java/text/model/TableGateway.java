package text.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TableGateway {
    private static final File file = new File("clients.txt");

    public static void save(int id, String name) {
        List<String[]> clients = readFile();
        boolean exists = clients.stream().anyMatch(client -> Integer.parseInt(client[0]) == id);
        if (!exists) {
            clients.add(new String[]{String.valueOf(id), name});
            writeToFile(clients);
        } else {
            System.out.println("Client with ID " + id + " already exists.");
        }
    }

    public static void delete(int id) {
        List<String[]> clients = readFile();
        clients.removeIf(client -> Integer.parseInt(client[0]) == id);
        writeToFile(clients);
    }

    public static void update(int id, String newName) {
        List<String[]> clients = readFile();
        for (String[] client : clients) {
            if (Integer.parseInt(client[0]) == id) {
                client[1] = newName;
            }
        }
        writeToFile(clients);
    }

    public static List<String[]> filterByName(String clientName) {
        List<String[]> clients = readFile();
        return clients.stream().filter(client -> client[1].equals(clientName)).toList();
    }

    private static void writeToFile(List<String[]> clients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String[] client : clients) {
                writer.write(client[0] + "," + client[1]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String[]> readFile() {
        List<String[]> clients = new ArrayList<>();
        if (!file.exists()) {
            return clients;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                clients.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }
}
