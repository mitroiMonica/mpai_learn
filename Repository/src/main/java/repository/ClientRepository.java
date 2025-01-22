package repository;

import model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements AbstractClientRepository {
    private static final File file = new File("clients_repository.txt");

    @Override
    public void add(Client client) {
        List<Client> clients = getAll();
        clients.add(client);
        writeToFile(clients);
    }

    @Override
    public Client getById(int id) {
        return getAll().stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        if (!file.exists()) {
            return clients;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                clients.add(new Client(id, name));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

    @Override
    public void update(Client client) {
        List<Client> clients = getAll();
        for (Client c : clients) {
            if (c.getId() == client.getId()) {
                c.setName(client.getName());
            }
        }
        writeToFile(clients);
    }

    @Override
    public void delete(int id) {
        List<Client> clients = getAll();
        clients.removeIf(client -> client.getId() == id);
        writeToFile(clients);
    }

    private void writeToFile(List<Client> clients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Client client : clients) {
                writer.write(client.getId() + "," + client.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}