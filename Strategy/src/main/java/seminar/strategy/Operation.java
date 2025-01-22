package seminar.strategy;

import java.util.List;

@FunctionalInterface
public interface Operation {
    double doCalculation(List<Integer> values);
}
