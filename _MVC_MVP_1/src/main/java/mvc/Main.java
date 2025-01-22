package mvc;

import mvc.model.ClientDataMapper;

public class Main {
    public static void main(String[] args) {
        ClientView view = new ClientView();
        ClientDataMapper mapper = new ClientDataMapper();
        Controller controller = new Controller(view, mapper);
        controller.start();
    }
}
