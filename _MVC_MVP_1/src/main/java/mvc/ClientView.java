package mvc;

import mvc.model.Client;

import java.util.Scanner;
import java.util.Set;

public class ClientView {
    private final Scanner scanner = new Scanner(System.in);

    public int menu() {
        int option = 0;
        while (true) {
            try {
                System.out.println("1. Add client");
                System.out.println("2. Update client");
                System.out.println("3. Delete client");
                System.out.println("4. Get all clients");
                System.out.println("5. Exit");
                System.out.print("Choose your option: ");
                option = Integer.parseInt(scanner.nextLine());
                if (option >= 1 && option <= 5) break;
                System.out.println("Invalid option. Please choose a number between 1 and 5.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return option;
    }

    public Client readClient() {
        System.out.print("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        return new Client(id, name);
    }

    public int readId() {
        System.out.print("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public void showClients(Set<Client> clients) {
        for (Client c : clients) {
            System.out.println(c);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
