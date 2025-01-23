package text.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecordGateway {
    private static final File file = new File("clients.txt");

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

    private static void writeToFile(List<RecordGateway> records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (RecordGateway record : records) {
                writer.write(record.getId() + "," + record.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<RecordGateway> readFile() {
        List<RecordGateway> records = new ArrayList<>();
        if (!file.exists()) {
            return records;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                int id = Integer.parseInt(items[0]);
                String name = items[1];
                records.add(new RecordGateway(id, name));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return records;
    }

    @Override
    public String toString() {
        return "RecordGateway{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
