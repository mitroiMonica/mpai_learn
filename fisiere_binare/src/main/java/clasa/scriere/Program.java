package clasa.scriere;

import clasa.Person;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        Person p1 = new Person("Ioan", 23, "Bucharest");
        Person p2 = new Person("Maria", 21, "Cluj");
        Person p3 = new Person("Ana", 23, "Dambovita");
        File file = new File("persons.bin");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(p1);
            objectOutputStream.writeObject(p2);
            objectOutputStream.writeObject(p3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
