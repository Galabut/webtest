package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Galabut on 23.01.2015.
 * - вывести всех клиентов порциями по 10 человек
 * - вывести всех клиентов наездивших на сумму больше указанной
 * - вывести всех клиентов, делавших заказы за последний месяц
 */
@Service("ClientServiceImpl")
public class ClientServiceImpl implements ClientService {
    List<Client> clients;

    @Autowired
    ClientDao dao;

    public boolean findClient(String name, String surname, String phone, String address) {
        clients = dao.findAll();
        Client clientFound=new Client(name,surname,phone,address);
        for (int i = 0; i < clients.size(); i++) {
            if (clientFound.equals(clients.get(i))) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        boolean clientFound=findClient(name,surname,phone,address);
        if (!clientFound) {
            dao.create(new Client(name, surname, phone, address));
            return true;
        }
        throw new ClientException("Such client already exists!");
    }

    @Override
    public List<Client> showClientsByPortion(int portionSize) {
        clients = dao.findAll(0, portionSize);
        return clients;
    }

    @Override
    public List<Client> showClientsGtSum(int sum) {
        clients = dao.showClientsGtSum(sum);
        return clients;
    }

    @Override
    public List<Client> showClientsLastMonth() {
        clients = dao.showClientsLastMonth();
        return clients;
    }
}
