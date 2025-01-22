package simplu.scriere;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        File file = new File("bin.bin");
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file))) {
            outputStream.writeUTF("Ana are mere si multe pere");
            outputStream.writeUTF("Cate pere?");
            outputStream.writeUTF("23");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
