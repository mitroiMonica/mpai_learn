import model.Client;
import model.Solicitare;
import model.chain.AbstractAngajat;
import model.chain.AngajatDeplasator;
import model.chain.AngajatOperator;
import model.query.Condition;
import model.query.Select;
import presenter.Presenter;
import view.AbstractView;
import view.View;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AbstractAngajat angajat1 = new AngajatOperator();
        AbstractAngajat angajat2 = new AngajatDeplasator();
        angajat1.setNextAngajat(angajat2);

        Client c1 = new Client("Ionel");
        Client c2 = new Client("Maria");
        Solicitare solicitare1 = new Solicitare("durere", "Bucuresti", c1);
        Solicitare solicitare2 = new Solicitare("durere", "Cluj", c2);

        angajat1.gestioneazaSolicitarea(solicitare1);

        Select select = new Select(Set.of(solicitare1, solicitare2));
        System.out.println(select.where(Condition.locationEquals("Bucuresti")).getResult());

        AbstractView view = new View();
        Presenter presenter = new Presenter(view);
        presenter.start();
    }
}
