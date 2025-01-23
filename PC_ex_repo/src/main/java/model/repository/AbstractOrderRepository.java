package model.repository;

import model.Client;
import model.Order;

import java.util.Set;
import java.util.UUID;

public interface AbstractOrderRepository {
    String insert(Order o);

    String update(Order o);

    String delete(UUID id);

    Set<Order> filterByClient(Client c);

    Set<Order> filterByNOProducts(int number);

    Set<Order> readFromFile();
}
