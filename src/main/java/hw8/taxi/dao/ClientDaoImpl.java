package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Galabut on 23.01.2015.
 */

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(ClientDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Client client) {
        Long id = 0L;
        try {
            Session session = sessionFactory.getCurrentSession();
            id = (Long) session.save(client);
        } catch (HibernateException e) {
            log.error("Session to Create Client failed", e);
        }
        return id;
    }

    @Override
    public Client read(Long id) {
        Client client = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            client = (Client) session.get(Client.class, id);
        } catch (HibernateException e) {
            log.error("Session to Read Client failed", e);
        }
        return client;
    }

    @Override
    public boolean update(Client client) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(client);
        } catch (HibernateException e) {
            log.error("Session to Update Client failed", e);
        }
        return true;
    }

    @Override
    public boolean delete(Client client) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(client);
        } catch (HibernateException e) {
            log.error("Session to Update Clients failed", e);
        }
        return true;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            clients = session.createCriteria(Client.class).list();
        } catch (HibernateException e) {
            log.error("Session to FindAll Clients failed", e);
        }
        return clients;
    }

    @Override
    public List<Client> findAll(int from, int to) {
        List<Client> clients = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            clients = session.createCriteria(Client.class).setFirstResult(from).setMaxResults(to).list();
        } catch (HibernateException e) {
            log.error("Session to FindAllByPortions Clients failed", e);
        }
        return clients;
    }

    @Override
    public List<Client> showClientsGtSum(int sum) {
        List<Client> clients = null;

        try {
            Session session = sessionFactory.getCurrentSession();

            clients = session.createCriteria(Client.class).add(Restrictions.gt("sum", sum)).list();
        } catch (HibernateException e) {
            log.error("Session to FindAllBySumOfOrders Clients failed", e);
        }
        return clients;
    }

    @Override
    public List<Client> showClientsLastMonth() {
        Date data = new Date();
        System.out.println(data + "data today");
        Date dateOfPreviousMonth = new Date (data.getTime() - 30 * 24 * 60 * 60 * 1000L);
        System.out.println(dateOfPreviousMonth);
                List < Client > clients = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            clients = session.createCriteria(Client.class).
                    add(Restrictions.between("lastOrderDate",dateOfPreviousMonth, data)).list();
            System.out.println(clients);
        } catch (HibernateException e) {
            log.error("Session to FindAllByLastMonth failed", e);
        }
        return clients;
    }
}
