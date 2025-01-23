package view;

import model.Product;

import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public int menu() {
        int option = 0;
        try {
            System.out.println("1. Add order");
            System.out.println("2. Update order");
            System.out.println("3. Delete order");
            System.out.println("4. Get all order");
            System.out.println("5. Filter by client");
            System.out.println("6. Filter by number of products");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid option!");
        }
        return option;
    }

    public int productMenu() {
        int option = 0;
        try {
            System.out.println("1. Add product");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid option!");
        }
        return option;
    }

    public UUID readId(String type) {
        System.out.print(type + " ID: ");
        return UUID.fromString(scanner.nextLine());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showProduct(Set<Product> products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public int readNumber() {
        System.out.print("Number of products: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
