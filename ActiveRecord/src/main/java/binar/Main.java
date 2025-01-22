package binar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Client client1 = new Client(1, "Ana", LocalDate.parse("11.03.2002", formatter));
        Client client2 = new Client(2, "Ioana", LocalDate.parse("21.03.2002", formatter));

        client1.insert();
        System.out.println(client1);

        client2.insert();
        System.out.println(client2);
        
        List<Client> clients = Client.citireFisier();
        System.out.println(clients);

        client2.delete();

    }
}
