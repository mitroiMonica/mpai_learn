package mvp;

public class Presenter {
    private final AbstractView view;
    private Client client;

    public Presenter(AbstractView view) {
        this.view = view;
    }

    public void start() {
        while (true) {
            int option = view.menu();
            if (option == 5) break;
            switch (option) {
                case 1:
                    addClient();
                    break;
                case 2:
                    updateClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                    getClients();
                    break;
                default:
                    view.showMessage("Invalid Option!");
            }
        }
    }

    private void addClient() {
        int id = view.readId();
        String name = view.readName();
        client = new Client(id, name);
        view.showMessage(client.insert());
    }

    private void updateClient() {
        int id = view.readId();
        String name = view.readName();
        client = new Client(id, name);
        view.showMessage(client.update());
    }

    private void deleteClient() {
        int id = view.readId();
        client = new Client(id, "");
        view.showMessage(client.delete());
    }

    private void getClients() {
        for (Client c : Client.readFromFile()) {
            view.showMessage(c.toString());
        }
    }

}
