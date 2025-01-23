package binar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RecordFilter {
    private static final List<RecordGateway> records;

    static {
        records = RecordGateway.readFile();
    }

    public static List<RecordGateway> filterByName(String name) {
        return records.stream()
                .filter(record -> record.getName().equals(name))
                .collect(Collectors.toList());
    }

    public static RecordGateway findById(int id) {
        return records.stream()
                .filter(record -> record.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
