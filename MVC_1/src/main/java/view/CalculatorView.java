package view;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public int getNumber() {
        System.out.print("Enter first number: ");
        return scanner.nextInt();
    }

    public void showResult(int result) {
        System.out.println("The result is: " + result);
    }
}
