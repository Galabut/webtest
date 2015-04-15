package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Galabut on 07.02.2015.
 */

public interface OrderService {
    boolean createOrder(Long id, String client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, String client, String amount, String addressFrom, String addressTo);
    List showOrders(Long from, Long to);
    List showOrdersByPortion();

}
