package singleton_registry.singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonRegistry {
    private static final Map<String, Object> registry;

    static {
        registry = new HashMap<>();
        registry.put("logger", new Logger());
        registry.put("databaseConnection", new DatabaseConnection());
    }

    public <T> T getInstance(String instanceName) {
        return (T) registry.get(instanceName);
    }

    public static class DatabaseConnection {
        private DatabaseConnection() {
        }
    }
}
