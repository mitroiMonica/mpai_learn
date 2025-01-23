package view;

import java.util.Scanner;
import java.util.UUID;

public class View implements AbstractView {
    private static final Scanner scanner = new Scanner(System.in);

    public int menu() {
        int option = 0;
        try {
            System.out.println("1. Add request");
            System.out.println("2. Update request");
            System.out.println("3. Delete request");
            System.out.println("4. Get all requests");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid option!");
        }
        return option;
    }

    public String readDescriere() {
        System.out.print("Descriere: ");
        return scanner.nextLine();
    }

    public String readLocatie() {
        System.out.print("Locatie: ");
        return scanner.nextLine();
    }

    public String readClientName() {
        System.out.print("Nume client: ");
        return scanner.nextLine();
    }

    public int readClientId() {
        System.out.print("ID Client: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public UUID readId() {
        System.out.print("ID Solicitare: ");
        return UUID.fromString(scanner.nextLine());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
