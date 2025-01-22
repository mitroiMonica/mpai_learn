package presenter;

import model.Calculator;
import view.View;

public class CalculatorPresenter {
    private Calculator calculator;
    private View view;

    public CalculatorPresenter(Calculator calculator, View view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void addNumbers() {
        int n1 = view.getNumber("Enter number 1: ");
        int n2 = view.getNumber("Enter number 2: ");
        calculator.setResult(n1 + n2);
        view.displayResult("The result is: " + calculator.getResult());
    }
}
