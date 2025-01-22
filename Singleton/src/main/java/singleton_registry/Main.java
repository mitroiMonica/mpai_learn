package singleton_registry;

import singleton_registry.singleton.Logger;
import singleton_registry.singleton.SingletonRegistry;

public class Main {
    public static void main(String[] args) {
        Logger logger = new SingletonRegistry().getInstance("logger");
        SingletonRegistry.DatabaseConnection databaseConnection =
                new SingletonRegistry().getInstance("databaseConnection");
        //we can instantiate SingletonRegistry as many times as we want
        //because the Map is static = so one single Map -> single instance for logger and dbConn
    }
}
