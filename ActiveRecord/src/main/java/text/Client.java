package text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final File fis = new File("clienti.txt");
    private int id;
    private String nume;

    public Client(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void insert() {
        List<Client> clients = citireFisier();
        boolean exists = clients.stream().anyMatch(client -> client.getId() == this.getId());
        if (!exists) {
            clients.add(this);
            scriereFisier(clients);
        } else {
            System.out.println("Client with ID " + this.getId() + " already exists.");
        }
    }

    public void delete() {
        List<Client> clients = citireFisier();
        clients.removeIf(client -> client.getId() == this.id);
        scriereFisier(clients);
    }

    public void update(String nume) {
        List<Client> clients = citireFisier();
        for (Client client : clients) {
            if (client.getId() == this.id) {
                client.setNume(nume);
            }
        }
        scriereFisier(clients);
    }

    static List<Client> citireFisier() {
        List<Client> clients = new ArrayList<>();
        if (!fis.exists()) {
            return clients;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String nume = parts[1];
                Client c = new Client(id, nume);
                clients.add(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

    static void scriereFisier(List<Client> clients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fis))) {
            for (Client client : clients) {
                writer.write(client.getId() + "," + client.getNume());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
