package repository;

import model.Client;

import java.util.List;

public interface AbstractClientRepository {
    void add(Client client);

    Client getById(int id);

    List<Client> getAll();

    void update(Client client);

    void delete(int id);
}
