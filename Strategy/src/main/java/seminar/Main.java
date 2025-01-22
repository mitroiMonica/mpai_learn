package seminar;

import seminar.strategy.Calculator;
import seminar.strategy.ProductOperation;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setStrategy(new ProductOperation());
        try {
            double result = calculator.calculate(4, 6, 8);
            System.out.println(result);
        } catch (UnsupportedOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
