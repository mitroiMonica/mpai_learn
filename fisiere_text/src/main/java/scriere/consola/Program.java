package scriere.consola;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Program {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            writer.write("Ana are mere!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
