package model.repository;

import model.Client;
import model.Order;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderRepository implements AbstractOrderRepository {
    private static final File file = new File("orders.bin");
    private static final Set<Order> orders = new HashSet<>();

    public String insert(Order o) {
        if (file.exists() && orders.isEmpty()) {
            readFromFile();
        }
        if (orders.contains(o)) {
            return "Order with id " + o.getId() + " is already in file";
        } else {
            orders.add(o);
            writeToFile();
            return "Order successfully placed!";
        }
    }

    public String update(Order o) {
        if (file.exists() && orders.isEmpty()) {
            readFromFile();
        }
        if (!orders.contains(o)) {
            return "Order with id " + o.getId() + " is not in file";
        } else {
            orders.remove(o);
            orders.add(o);
            writeToFile();
            return "Order successfully updated!";
        }
    }

    public String delete(UUID id) {
        Order o = new Order(id);
        if (file.exists() && orders.isEmpty()) {
            readFromFile();
        }
        if (!orders.contains(o)) {
            return "Order with id " + id + " is not in file";
        } else {
            orders.remove(o);
            writeToFile();
            return "Order successfully deleted!";
        }
    }

    public Set<Order> filterByClient(Client c) {
        if (file.exists() && orders.isEmpty()) {
            readFromFile();
        }
        return orders.stream().filter(o -> o.getClient().getId() == c.getId()).collect(Collectors.toSet());
    }

    public Set<Order> filterByNOProducts(int number) {
        if (file.exists() && orders.isEmpty()) {
            readFromFile();
        }
        return orders.stream().filter(o -> o.getProducts().size() >= number).collect(Collectors.toSet());
    }

    public Set<Order> readFromFile() {
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (true) {
                    try {
                        Order o = (Order) ois.readObject();
                        orders.add(o);
                    } catch (EOFException e) {
                        break;
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return orders;
    }

    private void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Order o : orders) {
                oos.writeObject(o);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
