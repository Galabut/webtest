package hw8.taxi.dao;

import hw8.taxi.domain.Client;

import java.util.List;

/**
 * Created by Galabut on 23.01.2015.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete(Client client);
    List<Client> findAll();
    List<Client> findAll(int from, int to);
    List<Client> showClientsGtSum(int sum);
    List<Client> showClientsLastMonth();
}