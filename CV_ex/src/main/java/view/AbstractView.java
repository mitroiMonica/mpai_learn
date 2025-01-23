package view;

import java.util.UUID;

public interface AbstractView {

    int menu();

    String readDescriere();

    String readLocatie();

    String readClientName();

    int readClientId();

    UUID readId();

    void showMessage(String message);

}
