package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Galabut on 07.02.2015.
 */
@Component ("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {
    @Override
    public boolean createOrder(Long id, String client, String amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public void editOrder(Long id, String client, String amount, String addressFrom, String addressTo) {

    }

    @Override
    public List showOrders(Long from, Long to) {
        return null;
    }

    @Override
    public List showOrdersByPortion() {
        return null;
    }
}
