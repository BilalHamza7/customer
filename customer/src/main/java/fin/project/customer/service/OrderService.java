package fin.project.customer.service;

import fin.project.customer.data.Customer;
import fin.project.customer.data.CustomerRepository;
import fin.project.customer.data.Order;
import fin.project.customer.data.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order placeOrder(Order order)    {
        return orderRepository.save(order);
    }

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
}
