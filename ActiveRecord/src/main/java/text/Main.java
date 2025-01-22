package text;


public class Main {
    public static void main(String[] args) {
        Client client = new Client(1,"Ana");
        Client client1 = new Client(2,"Ioana");
        client1.insert();
        client.insert();
        client1.delete();
    }
}
