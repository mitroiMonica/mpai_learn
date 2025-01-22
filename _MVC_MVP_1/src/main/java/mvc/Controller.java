package mvc;

import mvc.model.Client;
import mvc.model.ClientDataMapper;

public class Controller {
    private ClientView view;
    private ClientDataMapper clientMapper;

    public Controller(ClientView view, ClientDataMapper clientMapper) {
        this.view = view;
        this.clientMapper = clientMapper;
    }

    public void start() {
        while (true) {
            int option = view.menu();
            if (option == 5) break;
            switch (option) {
                case 1 -> handleAddClient();
                case 2 -> handleUpdateClient();
                case 3 -> handleDeleteClient();
                case 4 -> handleShowClients();
                default -> view.showMessage("Invalid option!");
            }
        }
    }

    private void handleAddClient() {
        Client c = view.readClient();
        view.showMessage(clientMapper.insert(c));
    }

    private void handleUpdateClient() {
        Client c = view.readClient();
        view.showMessage(clientMapper.update(c));
    }

    private void handleDeleteClient() {
        int id = view.readId();
        view.showMessage(clientMapper.delete(new Client(id, "")));
    }

    private void handleShowClients() {
        view.showClients(clientMapper.getClientsFromFile());
    }
}
