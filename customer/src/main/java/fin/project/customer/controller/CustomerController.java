package fin.project.customer.controller;

import fin.project.customer.data.Customer;
import fin.project.customer.data.CustomerLogin;
import fin.project.customer.service.CustomerLoginService;
import fin.project.customer.service.CustomerService;
import fin.project.customer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fin.project.customer.data.Order;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerLoginService customerLoginService;

    @Autowired
    OrderService orderService;

    @PostMapping("/customer/verifyCustomer")
    public Optional<CustomerLogin> verifyUser(@RequestBody CustomerLogin credentials) {
        return customerLoginService.verifyUser(credentials.getUsername(), credentials.getPassword());
    }

    @PostMapping("/customer/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customer/getCustomer")
    public Optional<Customer> getCustomer(@RequestParam int id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/customer/getCustomerLogin")
    public Optional<CustomerLogin> getCustomerLogin(@RequestParam int id){
        return customerLoginService.getCustomerLogin(id);
    }

    @PutMapping("/customer/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer, @RequestParam int id){
        return customerService.updateCustomer(customer, id);
    }

    @PutMapping("/customer/updateCustomerLogin")
    public CustomerLogin updateCustomerLogin(@RequestBody CustomerLogin customerLogin, @RequestParam int id){
        return customerLoginService.updateCustomerLogin(customerLogin, id);
    }

    @PostMapping("/customer/recordCredentials")
    public int recordCredentials(@RequestBody CustomerLogin createLogin){
        return customerLoginService.recordCredentials(createLogin);
    }

    @PostMapping("/order/placeOrder")
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }

    @GetMapping("/order/getOrder")
    public List<Order> getOrder(){
        return orderService.getOrder();
    }
}
