package main;

import model.Person;
import service.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Person p1 = new Person("Ionel", LocalDate.parse("11.05.2003", formatter));
        Person p2 = new Person("Marian", LocalDate.parse("11.07.2002", formatter));
        Set<Person> persons = new HashSet<>(Set.of(p1, p2));
        String insertSql = "INSERT INTO Person(name, birthday) VALUES(?, ?)";
        String createTableSql = "CREATE TABLE IF NOT EXISTS Person (" +
                "name VARCHAR(255)," +
                "birthday DATE," +
                "PRIMARY KEY ( name ))";
        String selectAllPersons = "SELECT * FROM Person";
        try (Connection connection = databaseConnection.getConnection();
             Statement statementTable = connection.createStatement();
             PreparedStatement statement = connection.prepareStatement(insertSql)) {
            boolean tableIsCreated = statementTable.execute(createTableSql);
            if (tableIsCreated) {
                System.out.println("Table successfully created!");
            }
            try (ResultSet rs = connection.createStatement().executeQuery(selectAllPersons)) {
                while (rs.next()) {
                    Person p = new Person(rs.getString(1), rs.getDate(2).toLocalDate());
                    if (persons.contains(p)) {
                        System.out.println(p + " already existed!");
                        persons.remove(p);
                    }
                }
            }
            for (Person p : persons) {
                statement.setString(1, p.getName());
                statement.setDate(2, Date.valueOf(p.getBirthday()));
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
