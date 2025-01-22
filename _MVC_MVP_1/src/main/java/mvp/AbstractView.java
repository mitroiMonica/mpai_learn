package mvp;

import java.util.Set;

public interface AbstractView {

    int menu();

    String readName();

    int readId();

    void showMessage(String message);
}
