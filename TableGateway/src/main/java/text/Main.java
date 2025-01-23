package text;

import text.model.Client;
import text.model.TableGateway;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client(1, "Ana");
        Client c2 = new Client(2, "Ioana");
        Client c3 = new Client(3, "Monica");

        TableGateway.save(c1.getId(), c1.getName());
        TableGateway.save(c2.getId(), c2.getName());
        TableGateway.save(c3.getId(), c3.getName());

        TableGateway.delete(2);

        TableGateway.readFile().forEach(client ->
                System.out.println("ID: " + client[0] + ", Name: " + client[1])
        );

        List<String[]> filteredClients = TableGateway.filterByName("Monica");
        for (String[] client : filteredClients) {
            System.out.println(Arrays.toString(client));
        }
    }
}
