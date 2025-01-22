package seminar.strategy;

import java.util.Arrays;

public class Calculator {
    private Operation strategy;

    public void setStrategy(Operation strategy) {
        this.strategy = strategy;
    }

    public double calculate(Integer... values) {
        if (strategy == null) {
            throw new UnsupportedOperationException();
        }
        return strategy.doCalculation(Arrays.asList(values));
    }
}
