package presenter;

import model.Client;
import model.Solicitare;
import view.AbstractView;
import view.View;

import java.util.UUID;

public class Presenter {
    private final AbstractView view;
    private Solicitare solicitare;

    public Presenter(AbstractView view) {
        this.view = view;
    }

    public void start() {
        while (true) {
            int option = view.menu();
            if (option == 5) break;
            switch (option) {
                case 1:
                    addSolicitare();
                    break;
                case 2:
                    updateSolicitare();
                    break;
                case 3:
                    deleteSolicitare();
                    break;
                case 4:
                    getSolicitares();
                    break;
                default:
                    view.showMessage("Invalid Option!");
            }
        }
    }

    private void addSolicitare() {
        String descriere = view.readDescriere();
        String locatie = view.readLocatie();
        String numeClient = view.readClientName();
        solicitare = new Solicitare(descriere, locatie, new Client(numeClient));
        view.showMessage(solicitare.insert());
    }

    private void updateSolicitare() {
        UUID id = view.readId();
        String descriere = view.readDescriere();
        String locatie = view.readLocatie();
        String numeClient = view.readClientName();
        solicitare = new Solicitare(descriere, locatie, new Client(numeClient));
        solicitare.setId(id);
        view.showMessage(solicitare.update());
    }

    private void deleteSolicitare() {
        UUID id = view.readId();
        solicitare.setId(id);
        view.showMessage(solicitare.delete());
    }

    private void getSolicitares() {
        for (Solicitare c : Solicitare.getFromFile()) {
            view.showMessage(c.toString());
        }
    }

}
