package view;

import model.Calculator;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);
    private Calculator calculator;

    public CalculatorView(Calculator calculator) {
        this.calculator = calculator;
    }

    public int getNumber() {
        System.out.print("Enter first number: ");
        return scanner.nextInt();
    }

    public void showResult() {
        System.out.println("The result is: " + calculator.getResult());
    }
}
