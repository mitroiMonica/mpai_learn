package main;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    private static SessionFactory getConnection() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Person p = new Person("Ionel", LocalDate.parse("11.12.2025", formatter));
        try (SessionFactory factory = getConnection();
             Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
        }

    }
}
