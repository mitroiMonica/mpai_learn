import model.Calculator;
import presenter.CalculatorPresenter;
import view.CalculatorView;
import view.View;

public class Program {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        View view = new CalculatorView();
        CalculatorPresenter presenter = new CalculatorPresenter(calculator, view);

        presenter.addNumbers();
    }
}
