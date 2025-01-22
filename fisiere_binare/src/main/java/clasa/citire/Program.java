package clasa.citire;

import clasa.Person;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        File file = new File("persons.bin");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Person p = (Person) objectInputStream.readObject();
                    System.out.println(p);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
