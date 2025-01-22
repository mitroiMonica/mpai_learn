package mvp;

import java.util.Scanner;

public class View implements AbstractView {
    private static final Scanner scanner = new Scanner(System.in);

    public int menu() {
        int option = 0;
        try {
            System.out.println("1. Add client");
            System.out.println("2. Update client");
            System.out.println("3. Delete client");
            System.out.println("4. Get all clients");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid option!");
        }
        return option;
    }

    public String readName() {
        System.out.print("ID: ");
        return scanner.nextLine();
    }

    public int readId() {
        System.out.print("ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
