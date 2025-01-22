package seminar.strategy;

import java.util.List;

public class SumOperation implements Operation {
    @Override
    public double doCalculation(List<Integer> values) {
        double sum = 0;
        for (Integer v : values) {
            sum += v;
        }
        return sum;
    }
}
