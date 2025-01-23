package text;

import text.model.Client;
import text.model.RecordFilter;
import text.model.RecordGateway;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(1, "John Doe");
        Client client2 = new Client(2, "Jane Doe");
        Client client3 = new Client(3, "John Smith");

        RecordGateway record1 = new RecordGateway(client1.getId(), client1.getName());
        RecordGateway record2 = new RecordGateway(client2.getId(), client2.getName());
        RecordGateway record3 = new RecordGateway(client3.getId(), client3.getName());

        record1.save();
        record2.save();
        record3.save();

        record1.update("John Updated");

        record2.delete();

        List<RecordGateway> filtered = RecordFilter.filterByName("John Updated");
        System.out.println("Filtered Records:");
        filtered.forEach(System.out::println);

        RecordGateway client = RecordFilter.findById(3);
        System.out.println("Client with ID 3: " + client);
    }
}
