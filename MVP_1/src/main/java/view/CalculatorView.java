package view;

import java.util.Scanner;

public class CalculatorView implements View {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int getNumber(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public void displayResult(String message) {
        System.out.println(message);
    }
}
