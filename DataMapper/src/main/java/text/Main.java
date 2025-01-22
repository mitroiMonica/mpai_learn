package text;


import text.model.ClientDataMapper;
import text.model.Client;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client(1, "Ana");
        Client c2 = new Client(2, "Ioana");

        ClientDataMapper.save(c1);
        ClientDataMapper.save(c2);

        ClientDataMapper.delete(c1);

        System.out.println(ClientDataMapper.readFile());
    }
}
