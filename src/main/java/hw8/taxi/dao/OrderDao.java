package hw8.taxi.dao;

import hw8.taxi.domain.Order;

/**
 * Created by Galabut on 07.02.2015.
 */
public interface OrderDao {
    Long create(Order order);
    Order read(Long id);
    boolean update(Order order);
    boolean delete(Order order);
}
