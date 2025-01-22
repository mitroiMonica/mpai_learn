package controller;

import model.Calculator;
import view.CalculatorView;

public class CalculatorController {
    private Calculator calculator;
    private CalculatorView view;

    public CalculatorController(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void addNumbers() {
        int n1 = view.getNumber();
        int n2 = view.getNumber();
        calculator.setResult(n1 + n2);
        view.showResult();
    }

    public void substractNumbers() {
        int n1 = view.getNumber();
        int n2 = view.getNumber();
        calculator.setResult(n1 - n2);
        view.showResult();
    }
}
