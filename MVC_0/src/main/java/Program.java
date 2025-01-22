import controller.CalculatorController;
import model.Calculator;
import view.CalculatorView;

public class Program {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorView view = new CalculatorView(calculator);
        CalculatorController controller = new CalculatorController(calculator, view);

        controller.addNumbers();
    }
}
