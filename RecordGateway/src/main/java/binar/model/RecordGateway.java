package binar.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecordGateway implements Serializable {
    private static final File file = new File("clients.bin");

    private int id;
    private String name;

    public RecordGateway(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    public void save() {
        List<RecordGateway> records = readFile();
        boolean exists = records.stream().anyMatch(r -> r.getId() == this.id);
        if (!exists) {
            records.add(this);
            writeToFile(records);
        } else {
            System.out.println("Record with ID " + this.id + " already exists.");
        }
    }

    public void delete() {
        List<RecordGateway> records = readFile();
        records.removeIf(record -> record.getId() == this.id);
        writeToFile(records);
    }

    public void update(String newName) {
        List<RecordGateway> records = readFile();
        for (RecordGateway record : records) {
            if (record.getId() == this.id) {
                record.setName(newName);
            }
        }
        writeToFile(records);
    }

    // Scrie lista completă în fișier
    private static void writeToFile(List<RecordGateway> records) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(records);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Citește întreaga listă de înregistrări din fișier
    @SuppressWarnings("unchecked")
    public static List<RecordGateway> readFile() {
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<RecordGateway>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return "RecordGateway{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
