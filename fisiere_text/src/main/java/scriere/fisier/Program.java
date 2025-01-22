package scriere.fisier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        File file = new File("./text.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Ana are mere!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
