package binar.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TableGateway {
    private static final File file = new File("clients.bin");

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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<String[]> readFile() {
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<String[]>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
