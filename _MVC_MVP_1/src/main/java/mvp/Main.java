package mvp;

public class Main {
    public static void main(String[] args) {
        AbstractView view = new View();
        Presenter presenter = new Presenter(view);
        presenter.start();
    }
}
