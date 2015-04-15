package hw8.taxi.dao;

import hw8.taxi.domain.Order;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Galabut on 07.02.2015.
 */
@Repository ("OrderDaoImpl")
@Transactional
public class OrderDaoImpl implements OrderDao {
    private static Logger log = Logger.getLogger(OrderDaoImpl.class);


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Order order) {
        return null;
    }

    @Override
    public Order read(Long id) {
        return null;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(Order order) {
        return false;
    }
}
