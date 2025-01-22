package seminar.strategy;

import java.util.List;

public class ProductOperation implements Operation {
    @Override
    public double doCalculation(List<Integer> values) {
        double product = 1;
        for (Integer v:values) {
            product *= v;
        }
        return product;
    }
}
