package mvc.model;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ClientDataMapper {
    private static final File file = new File("clienti.bin");
    private static Set<Client> clients = new HashSet<>();

    public String insert(Client c) {
        if (file.exists() && clients.isEmpty()) {
            clients = getClientsFromFile();
        }
        boolean isNotAlready = clients.add(c);
        if (!isNotAlready) {
            return "Client already existing!";
        } else {
            writeClientsToFile(clients);
            return "Client has been successfully inserted!";
        }
    }

    public String delete(Client c) {
        if (file.exists()) {
            if (clients.isEmpty()) {
                clients = getClientsFromFile();
            }
            boolean wasInFile = clients.remove(c);
            if (wasInFile) {
                writeClientsToFile(clients);
                return "Client has been successfully deleted!";
            } else {
                return "No such client in file!";
            }
        } else {
            return "No clients in file!";
        }
    }

    public String update(Client c) {
        if (file.exists()) {
            if (clients.isEmpty()) {
                clients = getClientsFromFile();
            }
            boolean isInFile = clients.contains(c);
            if (isInFile) {
                clients.remove(c);
                clients.add(c);
                writeClientsToFile(clients);
                return "Client has been successfully deleted!";
            } else {
                return "No such client in file!";
            }
        } else {
            return "No clients in file!";
        }
    }

    private void writeClientsToFile(Set<Client> clients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Client c : clients) {
                oos.writeObject(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Set<Client> getClientsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Client c = (Client) ois.readObject();
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
