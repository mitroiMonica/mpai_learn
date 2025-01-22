import model.Client;
import repository.AbstractClientRepository;
import repository.ClientRepository;

public class Main {
    public static void main(String[] args) {
        AbstractClientRepository repository = new ClientRepository();
        
        repository.add(new Client(1, "Ion Popescu"));
        repository.add(new Client(2, "Maria Ionescu"));

        repository.getAll().forEach(System.out::println);

        Client client = repository.getById(1);
        System.out.println("Client găsit: " + client);

        client.setName("Ion Popa");
        repository.update(client);

        repository.delete(2);

        repository.getAll().forEach(System.out::println);
    }
}
