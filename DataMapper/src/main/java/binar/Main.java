package binar;

import binar.model.Client;
import binar.model.ClientDataMapper;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client(1, "Ana");
        Client c2 = new Client(2, "Ioana");

        ClientDataMapper.insert(c1);
        ClientDataMapper.insert(c2);

        System.out.println(ClientDataMapper.readFile());
    }
}
