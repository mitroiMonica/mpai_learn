package simplu.citire;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        File file = new File("./bin.bin");
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    String line = inputStream.readUTF();
                    System.out.println(line);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
